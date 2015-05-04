package com.iyoumei.gearman.client;

import java.io.UnsupportedEncodingException;

public class TestClient {

	public static void main(String[] args) throws UnsupportedEncodingException {
		EvaluateUpClient up = new EvaluateUpClient() ;
		//95806061616824687   95806061616824331
		String params[] = {"from=95806061616824331","to=95806061616824691","ext=module_id#P20000001&from#95806061616824331"} ;
		up.submitJob(1, "common-worker","transmission", params);
	}
}
