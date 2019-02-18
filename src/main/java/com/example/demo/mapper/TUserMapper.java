package com.example.demo.mapper;

import com.example.demo.model.TUser;

import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<TUser> selectAllUser();
}