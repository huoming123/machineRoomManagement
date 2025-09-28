package com.design.machineManagementSystem.service.impl;

import com.design.machineManagementSystem.pojo.Machine;
import com.design.machineManagementSystem.mapper.MachineMapper;
import com.design.machineManagementSystem.service.MachineService;
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
 * (Machine)表服务实现类
 *
 * @author makejava
 */
@Service("machineService")
public class MachineServiceImpl implements MachineService {
    @Autowired
    private MachineMapper machineMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Machine> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Machine> list= machineMapper.getPageSearchByCondition(page);
        //根据条件查询数据的条数
        Integer count = machineMapper.getPageSearchCount(page);
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
    public RestFulBean<Machine> queryById(Integer id) {
       Machine machine=this.machineMapper.queryById(id);
         return RestFulBean.succ(machine);
    }

    /**
     * 新增数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Machine machine) {
        if(machine.getRoomNo()==null){
            return RestFulBean.error("机房号不能为空");
        }
        Machine machined =machineMapper.getByMachineRoom(machine.getRoomNo());
        if(machined !=null){
            return RestFulBean.error("该机房号已经录入");
        }
        this.machineMapper.increased(machine);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Machine machine) {
        this.machineMapper.edit(machine);//执行数据库的修改语句 根据id 修改
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
        this.machineMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Machine>> getMachineList() {
        List<Machine> list =machineMapper.getMachineList();
        return RestFulBean.succ(list);
    }

}
