package com.qdu.diaisheng.dao;

import com.qdu.diaisheng.entity.DataModel;
import java.util.List;

public interface DataModelDao {
    int insertDataModel(DataModel dataModel);
    List<DataModel> queryDataModelByDeviceId(String Device);
}
