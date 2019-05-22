package com.qdu.diaisheng.dao;

import com.qdu.diaisheng.BaseTest;
import com.qdu.diaisheng.entity.DataModel;
import com.qdu.diaisheng.entity.DataPoint;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DataPointTest extends BaseTest {
    @Autowired
    private DataPointDao dataPointDao;
    @Test
    public void testInsetDataPoint(){
        DataPoint dataPoint=new DataPoint();
        dataPoint.setDataPointId("374300");
        DataModel dataModel=new DataModel();
        dataModel.setDataModelId(1);
        dataPoint.setDataModel(dataModel);
        dataPoint.setDataPointName("controller");
        dataPoint.setDataType(0);
        dataPoint.setDataPointRegister("Ox4000f");
        dataPoint.setPower(0);
        dataPoint.setDataValueType("int");

        dataPoint.setCreateTime(new Date());
        int effectedNum=dataPointDao.insertDataPoint(dataPoint);
        System.out.println(effectedNum);

    }

}
