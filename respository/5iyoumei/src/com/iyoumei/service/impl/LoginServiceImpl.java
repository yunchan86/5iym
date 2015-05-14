package com.iyoumei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.iyoumei.bean.ServiceResultBean;
import com.iyoumei.entity.UserInfo;
import com.iyoumei.entity.UserInfoExample;
import com.iyoumei.mapper.UserInfoMapper;
import com.iyoumei.modeldriver.LoginMd;
import com.iyoumei.service.ILoginService;
import com.iyoumei.util.constant.Constant;
import com.iyoumei.util.enumcollection.IResMsg;
import com.iyoumei.util.enumcollection.RespCode;

public class LoginServiceImpl implements ILoginService {

	@Resource(type=UserInfoMapper.class)
	private UserInfoMapper userInfoMapper;
	
	@Override
	public ServiceResultBean<UserInfo, IResMsg> selectUserInfo(LoginMd loginMd) {
		UserInfoExample _userInfoExample = new UserInfoExample() ;
		
		UserInfoExample.Criteria _criteria = _userInfoExample.createCriteria() ;
		_criteria.andUserNameEqualTo(loginMd.getUserName()) ;
		_criteria.andLoginPasswordEqualTo(loginMd.getPassWord()) ;
		
		List<UserInfo> _userInfos = userInfoMapper.selectByExample(_userInfoExample) ;
		UserInfo _userInfo = null ;
		RespCode _code = RespCode.SUCCESS ;
		String _resultStr = Constant.ERROR ;
		if (_userInfos == null || _userInfos.isEmpty()) {
			_code = RespCode.USERNAME_OR_PWD_ERROR ;
		}else {
			_userInfo = _userInfos.get(0) ;
			_resultStr = Constant.SUCC ;
		}
		
		ServiceResultBean<UserInfo, IResMsg> _result = new ServiceResultBean<UserInfo, IResMsg>() ;
		_result.setResMsg(_code);
		_result.setData(_userInfo);
		_result.setResult(_resultStr);
		
		return _result;
	}

}
