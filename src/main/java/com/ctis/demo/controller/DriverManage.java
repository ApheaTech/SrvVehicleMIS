package com.ctis.demo.controller;

import com.ctis.demo.mapper.CarInfoMapper;
import com.ctis.demo.mapper.DriverInfoMapper;
import com.ctis.demo.pojo.CarInfo;
import com.ctis.demo.pojo.DriverInfo;
import com.ctis.demo.pojo.DriverInfoVO;
import com.ctis.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/driver")
public class DriverManage {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public int addDriver(DriverInfoVO driverInfoVO){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverInfoMapper mapper = sqlSession.getMapper(DriverInfoMapper.class);

        String driverID = UUID.randomUUID().toString().replace("-", "");
        DriverInfo driverInfo = new DriverInfo(driverID, driverInfoVO.getDriverName(), driverInfoVO.getPhone(), driverInfoVO.isGender(), driverInfoVO.getOrgID(), true);
        int ret = mapper.addDriver(driverInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public int deleteDriver(String driverID){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverInfoMapper mapper = sqlSession.getMapper(DriverInfoMapper.class);

        int ret = mapper.deleteDriver(driverID);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public int updateDriver(DriverInfo driverInfo){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverInfoMapper mapper = sqlSession.getMapper(DriverInfoMapper.class);

        int ret = mapper.updateDriver(driverInfo);

        sqlSession.commit();
        sqlSession.close();

        return ret;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<DriverInfoVO> getDriverList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverInfoMapper mapper = sqlSession.getMapper(DriverInfoMapper.class);

        List<DriverInfoVO> driverVOs = mapper.getDriverList();

        sqlSession.commit();
        sqlSession.close();

        return driverVOs;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DriverInfoVO getDriver(String driverID){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverInfoMapper mapper = sqlSession.getMapper(DriverInfoMapper.class);

        DriverInfoVO driverList = mapper.getDriver(driverID);

        sqlSession.commit();
        sqlSession.close();

        return driverList;
    }

}
