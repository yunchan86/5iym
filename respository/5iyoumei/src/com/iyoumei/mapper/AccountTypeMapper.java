package com.iyoumei.mapper;

import com.iyoumei.entity.AccountType;
import com.iyoumei.entity.AccountTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountTypeMapper {
    int countByExample(AccountTypeExample example);

    int deleteByExample(AccountTypeExample example);

    int deleteByPrimaryKey(String accountType);

    int insert(AccountType record);

    int insertSelective(AccountType record);

    List<AccountType> selectByExample(AccountTypeExample example);

    AccountType selectByPrimaryKey(String accountType);

    int updateByExampleSelective(@Param("record") AccountType record, @Param("example") AccountTypeExample example);

    int updateByExample(@Param("record") AccountType record, @Param("example") AccountTypeExample example);

    int updateByPrimaryKeySelective(AccountType record);

    int updateByPrimaryKey(AccountType record);
}