package com.example.service.impl;

import com.example.mybatis.dao.UsersMapper;
import com.example.mybatis.pojo.Users;
import com.example.mybatis.pojo.UsersExample;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/6/11.
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    public int login(Users users) {
        UsersExample usersExample=new UsersExample();
        usersExample.createCriteria().andUsernameEqualTo(users.getUsername()).andPasswordEqualTo(users.getPassword());
        List<Users> list=usersMapper.selectByExample(usersExample);
        return list.size();
    }
}
