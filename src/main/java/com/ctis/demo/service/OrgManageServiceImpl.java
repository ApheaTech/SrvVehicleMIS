package com.ctis.demo.service;

import com.ctis.demo.mapper.OrgInfoMapper;
import com.ctis.demo.pojo.OrgInfo;
import com.ctis.demo.pojo.OrgInfoVO;
import com.ctis.demo.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * TODO
 *
 * @author 航
 * @date 2021/8/11 17:02
 */
@Service
public class OrgManageServiceImpl implements OrgManageService{

    @Autowired
    OrgInfoMapper orgInfoMapper;

    @Override
    public int addOrg(OrgInfo orgInfo) {

        orgInfo.setOrgID(UUID.randomUUID().toString().replace("-", ""));
        orgInfo.setActive(true);
        System.out.println("orgID:"+orgInfo.getOrgID());
        return this.orgInfoMapper.addOrg(orgInfo);
    }

    @Override
    public int deleteOrg(String orgID) {

        return this.orgInfoMapper.deleteOrg(orgID);
    }

    @Override
    public int updateOrg(OrgInfo orgInfo) {

        return this.orgInfoMapper.updateOrg(orgInfo);
    }

    @Override
    public List<OrgInfoVO> getOrgList() {

        return this.orgInfoMapper.getOrgList();
    }

    @Override
    public TreeNode getOrgTree() {

        List<OrgInfoVO> orgInfoVOS = this.orgInfoMapper.getOrgList();
        HashMap<String, List> orgInfoMap = new HashMap<>();
        for (OrgInfoVO orgInfoVO : orgInfoVOS) {
            ArrayList<String> list = new ArrayList<>();
            list.add(orgInfoVO.getParentOrgID());
            list.add(orgInfoVO.getOrgName());
            orgInfoMap.put(orgInfoVO.getOrgID(), list);
        }
        return TreeNode.buildTree(orgInfoMap);
    }

    @Override
    public OrgInfoVO getOrg(String orgID) {

        return this.orgInfoMapper.getOrg(orgID);
    }
}
