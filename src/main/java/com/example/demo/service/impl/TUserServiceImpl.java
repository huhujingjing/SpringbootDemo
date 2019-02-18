package com.example.demo.service.impl;

import com.example.demo.mapper.TUserMapper;
import com.example.demo.model.TUser;
import com.example.demo.service.TUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: HUJING
 * @Date: 2019/2/14 17:04
 * @Version 1.0
 * @Description:
 */
@Service("TUserService")
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return mapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(TUser record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(TUser record) {
        return mapper.insertSelective(record);
    }

    @Override
    public TUser selectByPrimaryKey(Integer userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(TUser record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TUser record) {
        return mapper.updateByPrimaryKey(record);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<TUser> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAllUser();
    }
}
