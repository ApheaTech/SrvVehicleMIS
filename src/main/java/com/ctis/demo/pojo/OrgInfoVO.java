package com.ctis.demo.pojo;

import com.ctis.demo.utils.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgInfoVO extends OrgInfo {
    private String parentOrgName;
}
