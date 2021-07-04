package com.ctis.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfoVO extends CarInfo{
    private String orgName;
    private String driverName;
    private String carTypeLabel;
    private String carStatusLabel;
}
