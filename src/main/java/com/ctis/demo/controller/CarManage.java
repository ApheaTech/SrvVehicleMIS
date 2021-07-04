package com.ctis.demo.controller;

import com.ctis.demo.mapper.CarInfoMapper;
import com.ctis.demo.pojo.CarInfo;
import com.ctis.demo.pojo.CarInfoVO;
import com.ctis.demo.pojo.CarStatus;
import com.ctis.demo.pojo.CarType;
import com.ctis.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarManage {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addCar(@RequestBody CarInfo carInfo){
        System.out.println("add "+carInfo);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        String carID = UUID.randomUUID().toString().replace("-", "");
        carInfo.setCarID(carID);
        carInfo.setActive(true);
        carInfo.setCarDispatchStatus(0);

        int ret = mapper.addCar(carInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public int deleteCar(String carID){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        int ret = mapper.deleteCar(carID);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateCar(@RequestBody CarInfo carInfo){
        System.out.println("update "+carInfo);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        int ret = mapper.updateCar(carInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public CarInfoVO getCar(String carID){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        CarInfoVO carInfoVO = mapper.getCar(carID);

        sqlSession.close();

        return carInfoVO;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<CarInfoVO> getCarList(int start, int end){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        List<CarInfoVO> carList = mapper.getCarList(start, end);

        sqlSession.close();

        return carList;
    }

    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public int getCarTotal(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        int total = mapper.getCarTotal();

        sqlSession.close();

        return total;
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public List<CarType> getCarTypeList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        List<CarType> carTypeList = mapper.getCarTypeList();

        sqlSession.close();
        return carTypeList;
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public List<CarStatus> getCarStatusList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CarInfoMapper mapper = sqlSession.getMapper(CarInfoMapper.class);

        List<CarStatus> carStatusList = mapper.getCarStatusList();

        sqlSession.close();
        return carStatusList;
    }


}
