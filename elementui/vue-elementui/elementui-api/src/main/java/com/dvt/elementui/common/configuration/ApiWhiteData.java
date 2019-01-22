package com.dvt.elementui.common.configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * API白名单列表
 * @author yinjihuan
 *
 */
public class ApiWhiteData {
	private static List<String> whiteApis = new ArrayList<String>();
	static {
		whiteApis.add("/ws/**"); //webservice
		whiteApis.add("/file/upload"); //上传
		whiteApis.add("/code/**"); //字典
	}
	public static List<String> getWhiteApis() {
		return whiteApis;
	}
	
	public static void add(String uri) {
		whiteApis.add(uri);
	}
}
