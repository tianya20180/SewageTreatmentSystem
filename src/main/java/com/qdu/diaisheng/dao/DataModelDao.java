package com.qdu.diaisheng.dao;

import com.qdu.diaisheng.entity.DataModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataModelDao {
    int insertDataModel(DataModel dataModel);//插入数据模板
    List<DataModel> queryDataModelByDeviceId(String Device);//查询数据模板
    int deleteDataModel(int dataModelId);//删除数据模板
    int updateDataModel(@Param("dataModelName") String dataModelName,
                        @Param("dataModelId") int dataModelId);//更新数据模板
}
