package com.ctis.demo.mapper;

import com.ctis.demo.pojo.UserInfo;
import com.ctis.demo.pojo.UserInfoVO;

import java.util.List;

public interface UserInfoMapper {
    String getPasswd(String userAccount);
    int addUser(UserInfo userInfo);
    int deleteUser(String userID);
    int updateUser(UserInfo UserInfo);
    List<UserInfoVO> getUserList();
    UserInfoVO getUser(String userID);
    UserInfoVO getUserByAccount(String userAccount);
}
