package com.qdu.diaisheng.service.impl;

import com.qdu.diaisheng.DataValueEnum;
import com.qdu.diaisheng.dao.DataVauleDao;
import com.qdu.diaisheng.dto.DataValueExecution;
import com.qdu.diaisheng.entity.DataValue;


import java.util.List;

import com.qdu.diaisheng.service.DataValueService;
import org.springframework.beans.factory.annotation.Autowired;



public class DataValueServiceImpl implements DataValueService {

    @Autowired
    private DataVauleDao dataValueDao;

    /*

    @Override
    public DataValueExecution addDataValue(DataValue dataValue) {
        if(dataValue!=null&&dataValue.getDataPoint()!=null&&dataValue.getDataPoint().getDataPointId()!=null){


            int effectedNum=dataValueDao.insertDataVaule(dataValue);
            if (effectedNum<0){
                throw new RuntimeException("插入数据错误");
            }

            return new DataValueExecution(DataValueEnum.SUCCESS,dataValue);

        }else {
            return new DataValueExecution(DataValueEnum.EMPTY);
        }
    }

    @Override
    public DataValueExecution getDataValueListByPointId(String ponitId) {
        DataValueExecution dve=new DataValueExecution();

        if(ponitId!=null){
            List<DataValue> dataValueList =dataValueDao.queryByDataPointId(ponitId);
            if(dataValueList!=null){
                dve.setDataValueList(dataValueList);
                dve.setCount(dataValueList.size());
                dve.setState(DataValueEnum.SUCCESS.getState());
            }
            else{
                dve.setState(DataValueEnum.EMPTY.getState());
            }
        }else{
            return new DataValueExecution(DataValueEnum.EMPTY);
        }
        return dve;
    }

    @Override
    public List<DataValue> getDataValueByDate(String date) {
        return dataValueDao.queryByDate(date);
    }

    @Override
    public DataValueExecution getDateValueListBetween(String date1, String date2) {
        DataValueExecution dve=new DataValueExecution();

        if(date1!=null&&date2!=null){
            List<DataValue> dataValueList =dataValueDao.queryBetweenDate(date1,date2);
            if(dataValueList!=null){
                dve.setDataValueList(dataValueList);
                dve.setCount(dataValueList.size());
                dve.setState(DataValueEnum.SUCCESS.getState());
            }
            else{
                dve.setState(DataValueEnum.EMPTY.getState());
            }
        }else{
            return new DataValueExecution(DataValueEnum.EMPTY);
        }
        return dve;
    }
    */
}
