package com.ctis.demo.service;

import com.ctis.demo.pojo.UserInfo;
import com.ctis.demo.pojo.UserInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserManageService {
    int addUser(UserInfo userInfo);
    int deleteUser(String userID);
    int updateUser(UserInfo userInfo);
    UserInfoVO getUser(String userID);
    UserInfoVO getUserByAccount(String userAccount);
    List<UserInfoVO> getUserList();
}
