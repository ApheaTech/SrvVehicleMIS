package com.ctis.demo.mapper;

import com.ctis.demo.pojo.OrgInfo;
import com.ctis.demo.pojo.OrgInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgInfoMapper {
     int addOrg(OrgInfo orgInfo);
     int deleteOrg(String orgID);
     int updateOrg(OrgInfo orgInfo);
     List<OrgInfoVO> getOrgList();
     OrgInfoVO getOrg(String orgID);
}
