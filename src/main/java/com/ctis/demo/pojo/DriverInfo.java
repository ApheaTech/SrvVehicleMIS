package com.ctis.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfo {
    private String driverID;
    private String driverName;
    private String phone;
    private boolean gender;
    private String orgID;
    private boolean active;
}
