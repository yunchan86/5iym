package com.iyoumei.mapper;

import com.iyoumei.entity.UserRelation;
import com.iyoumei.entity.UserRelationExample;
import com.iyoumei.entity.UserRelationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRelationMapper {
    int countByExample(UserRelationExample example);

    int deleteByExample(UserRelationExample example);

    int deleteByPrimaryKey(UserRelationKey key);

    int insert(UserRelation record);

    int insertSelective(UserRelation record);

    List<UserRelation> selectByExample(UserRelationExample example);

    UserRelation selectByPrimaryKey(UserRelationKey key);

    int updateByExampleSelective(@Param("record") UserRelation record, @Param("example") UserRelationExample example);

    int updateByExample(@Param("record") UserRelation record, @Param("example") UserRelationExample example);

    int updateByPrimaryKeySelective(UserRelation record);

    int updateByPrimaryKey(UserRelation record);
}