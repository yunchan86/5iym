package com.iyoumei.mapper;

import com.iyoumei.entity.RemitLog;
import com.iyoumei.entity.RemitLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemitLogMapper {
    int countByExample(RemitLogExample example);

    int deleteByExample(RemitLogExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(RemitLog record);

    int insertSelective(RemitLog record);

    List<RemitLog> selectByExample(RemitLogExample example);

    RemitLog selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") RemitLog record, @Param("example") RemitLogExample example);

    int updateByExample(@Param("record") RemitLog record, @Param("example") RemitLogExample example);

    int updateByPrimaryKeySelective(RemitLog record);

    int updateByPrimaryKey(RemitLog record);
}