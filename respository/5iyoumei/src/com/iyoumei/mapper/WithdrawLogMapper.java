package com.iyoumei.mapper;

import com.iyoumei.entity.WithdrawLog;
import com.iyoumei.entity.WithdrawLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawLogMapper {
    int countByExample(WithdrawLogExample example);

    int deleteByExample(WithdrawLogExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(WithdrawLog record);

    int insertSelective(WithdrawLog record);

    List<WithdrawLog> selectByExample(WithdrawLogExample example);

    WithdrawLog selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") WithdrawLog record, @Param("example") WithdrawLogExample example);

    int updateByExample(@Param("record") WithdrawLog record, @Param("example") WithdrawLogExample example);

    int updateByPrimaryKeySelective(WithdrawLog record);

    int updateByPrimaryKey(WithdrawLog record);
}