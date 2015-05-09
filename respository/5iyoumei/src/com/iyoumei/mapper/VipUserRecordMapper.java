package com.iyoumei.mapper;

import com.iyoumei.entity.VipUserRecord;
import com.iyoumei.entity.VipUserRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VipUserRecordMapper {
    int countByExample(VipUserRecordExample example);

    int deleteByExample(VipUserRecordExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(VipUserRecord record);

    int insertSelective(VipUserRecord record);

    List<VipUserRecord> selectByExample(VipUserRecordExample example);

    VipUserRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") VipUserRecord record, @Param("example") VipUserRecordExample example);

    int updateByExample(@Param("record") VipUserRecord record, @Param("example") VipUserRecordExample example);

    int updateByPrimaryKeySelective(VipUserRecord record);

    int updateByPrimaryKey(VipUserRecord record);
}