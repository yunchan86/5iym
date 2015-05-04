package com.iyoumei.persistence;

import org.apache.ibatis.annotations.Select;

public interface UuidMapper {
	@Select("SELECT Uuid_short()")
	String getUuidShort();

	@Select("SELECT Uuid()")
	String getUuid();
}
