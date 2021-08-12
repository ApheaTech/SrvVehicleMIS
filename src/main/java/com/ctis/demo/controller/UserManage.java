package com.ctis.demo.controller;

import com.ctis.demo.mapper.CarInfoMapper;
import com.ctis.demo.mapper.UserInfoMapper;
import com.ctis.demo.pojo.*;
import com.ctis.demo.service.UserManageService;
import com.ctis.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserManage {

    @Autowired
    UserManageService userManageService;

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public boolean login(@RequestBody UserLoginVO userLoginVO){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
//
//        String passwd = mapper.getPasswd(userLoginVO.getUserAccount());
//
//        sqlSession.close();
//
//        if (passwd.equals(userLoginVO.getPasswd())){
//            return true;
//        }else {
//            return false;
//        }
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addUser(@RequestBody UserInfo userInfo){

        return this.userManageService.addUser(userInfo);
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable String userID){

        return this.userManageService.deleteUser(userID);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateUser(@RequestBody UserInfo userInfo){

        return this.userManageService.updateUser(userInfo);
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public UserInfoVO getUser(@PathVariable String userID){

        return this.userManageService.getUser(userID);
    }

    @RequestMapping(value = "/account/{userAccount}", method = RequestMethod.GET)
    public UserInfoVO getUserByAccount(@PathVariable String userAccount){

        return this.userManageService.getUserByAccount(userAccount);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserInfoVO> getUserList(){

        return this.userManageService.getUserList();
    }
}
