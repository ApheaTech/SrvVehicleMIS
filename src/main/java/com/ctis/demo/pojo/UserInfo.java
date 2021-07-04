package com.ctis.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String userID;
    private String userAccount;
    private String userName;
    private String passwd;
    private String orgID;
    private boolean gender;
    private boolean active;
}
