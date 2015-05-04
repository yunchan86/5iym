package com.iyoumei.gearman.client;

import java.util.Map;

import com.iyoumei.gearman.client.util.CommonCode;
import com.iyoumei.gearman.client.util.GearmanCode;
import com.iyoumei.util.StringUtil;

public class EvaluateUpDown  extends AbsClientJob{

	@SuppressWarnings("rawtypes")
	protected GearmanCode verifyParams(String workerName, Map map) {
		GearmanCode code = new GearmanCode(CommonCode.SUCCESS,"成功",null) ;
		verifyMap(code,map) ;
		return code;
	}
	
	@SuppressWarnings("rawtypes")
	private void verifyMap(GearmanCode gcode,Map map) {
		String from = (String) map.get("from") ;
		String to = (String) map.get("to") ;
		String ext = (String) map.get("ext") ;
		if(StringUtil.isNull(from)) {
			gcode.setGearmanCode(CommonCode.PARAM_NOT_NULL, "from参数不能为空", null);
			return ;
		}
		if(StringUtil.isNull(to)) {
			gcode.setGearmanCode(CommonCode.PARAM_NOT_NULL, "to参数不能为空", null);
			return ;
		}
		if(StringUtil.isNull(ext)) {
			gcode.setGearmanCode(CommonCode.PARAM_NOT_NULL, "ext参数不能为空", null);
			return ;
		}
	}
	

/*	public static void main(String[] args) {
		EvaluateUpClient ev = new EvaluateUpClient() ;
		String params[] = {"key1=value1","key2=value2","key3=value3","key4=key41#value41&key42#value42"} ;
		Map map = ev.getParamsMap(params) ;
		System.out.println(map);
	}*/
	
}
