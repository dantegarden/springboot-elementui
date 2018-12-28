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
		whiteApis.add("/file/upload");
		whiteApis.add("/code/**");
	}
	public static List<String> getWhiteApis() {
		return whiteApis;
	}
	
	public static void add(String uri) {
		whiteApis.add(uri);
	}
}
