package com.ctis.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgInfo {
    private String orgID;
    private String orgName;
    private String parentOrgID;
    private boolean active;
}
