package com.ctis.demo.controller;

import com.ctis.demo.mapper.CarInfoMapper;
import com.ctis.demo.mapper.OrgInfoMapper;
import com.ctis.demo.mapper.UserInfoMapper;
import com.ctis.demo.pojo.*;
import com.ctis.demo.service.OrgManageService;
import com.ctis.demo.utils.MybatisUtils;
import com.ctis.demo.utils.TreeNode;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/org")
public class OrgManage {

    @Autowired
    OrgManageService orgManageService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addOrg(@RequestBody OrgInfo orgInfo) {

        return this.orgManageService.addOrg(orgInfo);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public int deleteOrg(String orgID) {

        return this.orgManageService.deleteOrg(orgID);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateOrg(OrgInfo orgInfo) {

        return this.orgManageService.updateOrg(orgInfo);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public TreeNode getOrgList() {

        return this.orgManageService.getOrgList();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public OrgInfoVO getOrg(String orgID) {

        return this.orgManageService.getOrg(orgID);
    }
}
