package com.example.demo.service;

import com.example.demo.model.TUser;

import java.util.List;

/**
 * @Author: HUJING
 * @Date: 2019/2/14 17:03
 * @Version 1.0
 * @Description:
 */
public interface TUserService {
    int deleteByPrimaryKey(Integer userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<TUser> findAllUser(int pageNum, int pageSize);
}
