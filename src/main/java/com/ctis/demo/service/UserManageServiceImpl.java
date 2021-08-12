package com.ctis.demo.service;

import com.ctis.demo.mapper.UserInfoMapper;
import com.ctis.demo.pojo.UserInfo;
import com.ctis.demo.pojo.UserInfoVO;
import com.ctis.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/11 15:16
 */
//@Service("userManageService")
@Service
public class UserManageServiceImpl implements UserManageService{

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public int addUser(UserInfo userInfo) {
        userInfo.setUserID(UUID.randomUUID().toString().replace("-", ""));
        userInfo.setActive(true);

        return this.userInfoMapper.addUser(userInfo);
    }

    @Override
    public int deleteUser(String userID) {
        return this.userInfoMapper.deleteUser(userID);
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        return this.userInfoMapper.updateUser(userInfo);
    }

    @Override
    public UserInfoVO getUser(String userID) {
        return this.userInfoMapper.getUser(userID);
    }

    @Override
    public UserInfoVO getUserByAccount(String userAccount) {
        return this.userInfoMapper.getUserByAccount(userAccount);
    }

    @Override
    public List<UserInfoVO> getUserList() {
        return this.userInfoMapper.getUserList();
    }
}
