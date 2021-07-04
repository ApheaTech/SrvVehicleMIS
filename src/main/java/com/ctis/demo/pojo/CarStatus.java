package com.ctis.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarStatus {
    private String carStatusValue;
    private String carStatusLabel;
}
