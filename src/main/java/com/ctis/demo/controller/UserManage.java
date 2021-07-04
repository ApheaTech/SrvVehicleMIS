package com.ctis.demo.controller;

import com.ctis.demo.mapper.CarInfoMapper;
import com.ctis.demo.mapper.UserInfoMapper;
import com.ctis.demo.pojo.*;
import com.ctis.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserManage {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody UserLoginVO userLoginVO){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        String passwd = mapper.getPasswd(userLoginVO.getUserAccount());

        sqlSession.close();

        if (passwd.equals(userLoginVO.getPasswd())){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addUser(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        userInfo.setUserID(UUID.randomUUID().toString().replace("-", ""));
        userInfo.setActive(true);

        int ret = mapper.addUser(userInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public int deleteUser(String userID){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        int ret = mapper.deleteUser(userID);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateUser(UserInfo userInfo){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        int ret = mapper.updateUser(userInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public UserInfoVO getUser(String userID){
        System.out.println("getUser: userID="+userID);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        UserInfoVO userInfoVO = mapper.getUser(userID);

        sqlSession.close();

        return userInfoVO;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public UserInfoVO getUserByAccount(String userAccount){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        UserInfoVO userInfoVO = mapper.getUserByAccount(userAccount);

        sqlSession.close();

        return userInfoVO;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserInfoVO> getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);

        List<UserInfoVO> userList = mapper.getUserList();

        sqlSession.close();

        return userList;
    }


}
