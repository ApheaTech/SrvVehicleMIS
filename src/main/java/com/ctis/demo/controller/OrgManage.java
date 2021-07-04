package com.ctis.demo.controller;

import com.ctis.demo.mapper.CarInfoMapper;
import com.ctis.demo.mapper.OrgInfoMapper;
import com.ctis.demo.mapper.UserInfoMapper;
import com.ctis.demo.pojo.*;
import com.ctis.demo.utils.MybatisUtils;
import com.ctis.demo.utils.TreeNode;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/org")
public class OrgManage {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addOrg(@RequestBody OrgInfo orgInfo){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);

        orgInfo.setOrgID(UUID.randomUUID().toString().replace("-", ""));
        orgInfo.setActive(true);
        System.out.println("orgID:"+orgInfo.getOrgID());
        int ret = mapper.addOrg(orgInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public int deleteOrg(String orgID){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);

        int ret = mapper.deleteOrg(orgID);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateOrg(OrgInfo orgInfo){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);

        int ret = mapper.updateOrg(orgInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<OrgInfoVO> getOrgList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);

        List<OrgInfoVO> orgList = mapper.getOrgList();

        sqlSession.close();
        return orgList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public OrgInfoVO getOrg(String orgID) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);

        OrgInfoVO orgInfoVO = mapper.getOrg(orgID);

        sqlSession.close();
        return orgInfoVO;
    }
}
