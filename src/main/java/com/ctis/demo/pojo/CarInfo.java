package com.ctis.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfo {
    private String carID;
    private String carNumber;
    private String orgID;
    private String driverID;
    private boolean active;
    private String carType;
    private String carStatus;
    private int carDispatchStatus;
}
