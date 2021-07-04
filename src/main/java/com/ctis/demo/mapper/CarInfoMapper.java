package com.ctis.demo.mapper;

import com.ctis.demo.pojo.CarInfo;
import com.ctis.demo.pojo.CarInfoVO;
import com.ctis.demo.pojo.CarStatus;
import com.ctis.demo.pojo.CarType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarInfoMapper {
    //增加一辆车
    int addCar(CarInfo carInfo);
    //根据id删除一辆车
    int deleteCar(@Param("carID") String carID);
    //修改一辆车的信息
    int updateCar(CarInfo carInfo);
    //查询所有的车辆
    List<CarInfoVO> getCarList(@Param("start") int start, @Param("end") int end);
    //根据id查询车辆
    CarInfoVO getCar(@Param("carID") String carID);

    int getCarTotal();

    List<CarType> getCarTypeList();

    List<CarStatus> getCarStatusList();
}

