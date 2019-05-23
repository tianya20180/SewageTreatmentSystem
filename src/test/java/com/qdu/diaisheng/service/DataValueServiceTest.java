package com.qdu.diaisheng.service;

import com.qdu.diaisheng.BaseTest;
import com.qdu.diaisheng.DataValueEnum;
import com.qdu.diaisheng.dto.DataValueExecution;
import com.qdu.diaisheng.entity.DataPoint;
import com.qdu.diaisheng.entity.DataValue;
import javafx.scene.chart.XYChart;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DataValueServiceTest extends BaseTest {
    @Autowired
    DataValueService dataValueService;


    @Test
    @Ignore
    public void testaddDataValue(){
        DataValue dataValue=new DataValue();
        DataPoint dataPoint=new DataPoint();
        dataPoint.setDataPointId("41607");
        dataValue.setDataPoint(dataPoint);
        dataValue.setValue(220f);


        dataValue.setCreateTime("2019-05-23 00:34:00");
        dataValueService.addDataValue(dataValue);
    }

    @Test

    public void testqueryByDateAndDatePoint(){
        String date="2019-05-23 00:34:00";

        String dataPointId="41607";
        DataValueExecution dve=dataValueService.getDataValueByPointIdAndDate(date,dataPointId);
        if(dve.getState()==DataValueEnum.SUCCESS.getState()){
            System.out.println(dve.getDataValue());
        }else{
            System.out.println("失败："+ dve.getStateInfo());

        }

    }
    @Test
    @Ignore
    public void testqueryAtDataPointBetweenDate(){
        String dataPointId="41607";
        String date1="2019-04-30 00:01:00";
        String date2="2019-04-30 00:34:00";
        DataValueExecution dataValueExecution=dataValueService.getDateValueListAtPointIdBetweenDate(date1,date2,dataPointId);
        if(dataValueExecution.getState()== DataValueEnum.SUCCESS.getState()){
            List<DataValue>dataValueList=dataValueExecution.getDataValueList();
            for(DataValue dv:dataValueList){
                System.out.println(dv);
            }
        }else{
            System.out.println("失败："+ dataValueExecution.getStateInfo());
        }
    }


}
