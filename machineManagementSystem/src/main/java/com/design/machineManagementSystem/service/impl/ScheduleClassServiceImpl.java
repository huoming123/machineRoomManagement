package com.design.machineManagementSystem.service.impl;

import com.design.machineManagementSystem.pojo.ScheduleClass;
import com.design.machineManagementSystem.mapper.ScheduleClassMapper;
import com.design.machineManagementSystem.service.ScheduleClassService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.machineManagementSystem.util.PageUtil;
import com.design.machineManagementSystem.dto.Page;
/**
 * (ScheduleClass)表服务实现类
 *
 * @author makejava
 */
@Service("scheduleClassService")
public class ScheduleClassServiceImpl implements ScheduleClassService {
    @Autowired
    private ScheduleClassMapper scheduleClassMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<ScheduleClass> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<ScheduleClass> list= scheduleClassMapper.getPageSearchByCondition(page);
        //根据条件查询数据的条数
        Integer count = scheduleClassMapper.getPageSearchCount(page);
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
    public RestFulBean<ScheduleClass> queryById(Integer id) {
       ScheduleClass scheduleClass=this.scheduleClassMapper.queryById(id);
         return RestFulBean.succ(scheduleClass);
    }

    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(ScheduleClass scheduleClass) {
        if(scheduleClass.getCourseName()==null)
        {
            return  RestFulBean.error("课程不能为空");
        }
        if(scheduleClass.getRoomNo()==null)
        {
            return   RestFulBean.error("机房号不能为空");
        }
        if(scheduleClass.getTeacherId()==null)
        {
            return  RestFulBean.error("教师不能为空");
        }
        if(scheduleClass.getWeekDay()==null)
        {
            return RestFulBean.error("时间不能为空");
        }
        if(scheduleClass.getStartTime()==null)
        {
            return  RestFulBean.error("时间段不能为空");
        }
        if(scheduleClass.getEndTime()==null)
        {
            return   RestFulBean.error("时间段不能为空");
        }
        if (scheduleClass.getStartTime().equals(scheduleClass.getEndTime())) {
            return RestFulBean.error("时间段不能相等");
        }
        Integer aa = null;
        //时间段根据：去切割数据 比如 08:00 切成 08 00
        System.out.println(scheduleClass.getStartTime().split(":")[0]+"隔开"+scheduleClass.getStartTime().split(":")[1]+"fdfdfd");
        String first = scheduleClass.getStartTime().split(":")[0]; //取第一个 比如 08
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
        String second = scheduleClass.getEndTime().split(":")[0];
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
            return RestFulBean.error("课程只能选两节课");
        }
        ScheduleClass scheduleClassed =scheduleClassMapper.getByDate(scheduleClass);//判断相同时间是否已有课表
        if(scheduleClassed!=null){
            return RestFulBean.error("该时间段已经有课表");
        }
        this.scheduleClassMapper.increased(scheduleClass);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(ScheduleClass scheduleClass) {
        this.scheduleClassMapper.edit(scheduleClass);//执行数据库的修改语句 根据id 修改
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
        this.scheduleClassMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
