package com.ctis.demo.mapper;

import com.ctis.demo.pojo.DriverInfo;
import com.ctis.demo.pojo.DriverInfoVO;

import java.util.List;

public interface DriverInfoMapper {
    int addDriver(DriverInfo driverInfo);
    int deleteDriver(String driverID);
    int updateDriver(DriverInfo driverInfo);
    List<DriverInfoVO> getDriverList();
    DriverInfoVO getDriver(String driverID);
}
