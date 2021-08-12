package com.ctis.demo.service;

import com.ctis.demo.pojo.OrgInfo;
import com.ctis.demo.pojo.OrgInfoVO;
import com.ctis.demo.utils.TreeNode;

import java.util.List;

public interface OrgManageService {
    int addOrg(OrgInfo orgInfo);
    int deleteOrg(String orgID);
    int updateOrg(OrgInfo orgInfo);
    List<OrgInfoVO> getOrgList();
    TreeNode getOrgTree();
    OrgInfoVO getOrg(String orgID);
}
