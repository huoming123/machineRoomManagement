package com.design.machineManagementSystem.service.impl;

import com.design.machineManagementSystem.pojo.Borrow;
import com.design.machineManagementSystem.mapper.BorrowMapper;
import com.design.machineManagementSystem.service.BorrowService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.machineManagementSystem.pojo.res.RestFulBean;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import com.design.machineManagementSystem.util.PageUtil;
import com.design.machineManagementSystem.dto.Page;
/**
 * (Borrow)表服务实现类
 *
 * @author makejava
 */
@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Borrow> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        if(page.getKey().getClassTime()!=null){            //根据留言日期搜索时 把时间转化为字符串进行搜索
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = fmt.format(page.getKey().getClassTime());
            page.setDateTime(dateStr);  //字符串日期赋值
        }
        //根据前端传来的的条件进行查询  //分页查询
        List<Borrow> list= borrowMapper.getPageSearchByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Borrow borrow: list){
               if(borrow.getChecked()==0){
                   borrow.setDisabled(false);
               }
               else{
                   borrow.setDisabled(true);
               }
            }
        }
        //根据条件查询数据的条数
        Integer count = borrowMapper.getPageSearchCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Borrow> queryById(Integer id) {
       Borrow borrow=this.borrowMapper.queryById(id);
         return RestFulBean.succ(borrow);
    }

    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Borrow borrow) {
        if (borrow.getStartTime().equals(borrow.getEndTime())) {
            return RestFulBean.error("时间段不能相等");
        }
        Integer aa = null;
        //时间段根据：去切割数据 比如 08:00 切成 08 00
        String first = borrow.getStartTime().split(":")[0]; //取第一个 比如 08
        if ("12".equals(first)) {  //判断开始时间段是否等于12
            return RestFulBean.error("时间段包含午休时间,请重新选择");
        }
        if (first.startsWith("0")) { //再判断切出来的第一个first 是否是0开头的 比如 08
            String result = first.split("0")[1]; //如果是 则根据0再切割 然后取第二个 则 取 8
            aa = Integer.parseInt(String.valueOf(result)); //把字符串转为整形
        } else {//如果不是0开头的 则 直接把它转为整形 比如 10
            aa = Integer.parseInt(String.valueOf(first));
        }
        //第二个时间的同理可得
        Integer bb = null;
        String second = borrow.getEndTime().split(":")[0];
        if (second.startsWith("0")) {
            String result1 = second.split("0")[1];
            bb = Integer.parseInt(String.valueOf(result1));
        } else {
            bb = Integer.parseInt(String.valueOf(second));
        }
        //第二个时间段减去第一个时间
        if (bb - aa < 0) {
            return RestFulBean.error("开始时间段不能大于结束时间段");
        }
        if (bb - aa > 2) {
            return RestFulBean.error("机房课程只能选两节课");
        }
        //获取系统当前时间
        Date date = new Date();
        //将当前日期时间转为毫秒值
        long t1 = date.getTime();
        //前端传来的上课时间
        long t2 = borrow.getClassTime().getTime();
        if(t2-t1<0){
            return RestFulBean.error("上课时间不能小于当前系统时间");
        }
        List<Borrow> list1  = new ArrayList<>();
        if(borrow.getStudentId()!=null){ //学生用户提交的申请
            //不让用户重复提交同个时间段同个机房的申请
            list1 = borrowMapper.getByStudentId(borrow);
        }
        else{//教师用户提交的申请
            //不让用户重复提交同个时间段同个机房的申请
            list1 = borrowMapper.getByTeacherId(borrow);
        }
        if(list1.size()>0){
            return RestFulBean.error("你已提交该申请,请不要重复申请");
        }
        //根据申请日期 和 开始时间 结束时间 查询数据 跟机房号
        List<Borrow> list = borrowMapper.getByTime(borrow);
        if(list.size()>0){
            return RestFulBean.error("该时间段该机房已经有人申请了,请改时间段或者换机房");
        }
        this.borrowMapper.increased(borrow);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Borrow borrow) {
        this.borrowMapper.edit(borrow);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.borrowMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getBorrowAnalyse(Borrow borrow) {
        Map result =new HashMap();
        List typeList = new ArrayList<>();
        if(borrow.getMonth()!=null){ //月份如果点击搜索
            borrow.setYearMonth(borrow.getYear().toString()+'-'+borrow.getMonth()); //处理一下日期 把它变成类型这样的 2025-02
        }
        List<Borrow> list  =borrowMapper.getBorrowAnalyse(borrow); //获取统计的机房预约数量
        for(Borrow borrowed:list){
            Map type =new HashMap();
            type.put("value",borrowed.getCount()); //机房预约数量
            type.put("name",borrowed.getRoomNo()); //机房名称
            typeList.add(type);
        }
        result.put("typeList",typeList);
        return RestFulBean.succ(result);
    }
}
