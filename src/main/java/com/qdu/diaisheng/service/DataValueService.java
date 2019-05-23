package com.qdu.diaisheng.service;

import com.qdu.diaisheng.dto.DataValueExecution;
import com.qdu.diaisheng.entity.DataValue;
import java.util.List;

import java.sql.Date;
import java.sql.Timestamp;

public interface DataValueService {



    DataValueExecution addDataValue(DataValue dataValue);

    DataValueExecution getDataValueListByPointId(String ponitId);

    DataValueExecution getDataValueByPointIdAndDate(String date,String pointId);

    List<DataValue> getDataValueListByDate(String date);

    DataValueExecution getDateValueListAtPointIdBetweenDate(String date1,String date2,String pointId);


}
