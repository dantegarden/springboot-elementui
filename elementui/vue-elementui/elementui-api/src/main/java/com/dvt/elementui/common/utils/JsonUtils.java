package com.dvt.elementui.common.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.DependsOn;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json 工具类
 *
 */
@DependsOn("springContextUtils")
public class JsonUtils {

	private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);

	private static ObjectMapper mapper = (ObjectMapper) SpringContextUtils.getBean("jacksonObjectMapper");
	
	public static String toString(Object obj){
		return toJson(obj);
	}
	
	public static String toJson(Object obj){
		try{
			StringWriter writer = new StringWriter();
			mapper.writeValue(writer, obj);
			return writer.toString();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
		}
	}
	
	public static <T> T toBean(Class<T> entityClass, String jsonString){
		try {
			return mapper.readValue(jsonString, entityClass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("JSON【"+jsonString+"】转对象时出错", e);
		}
	}

	public static <T> List<T> toList(Class<T> listClass, String jsonString){
		try {
			JavaType javaType =  mapper.getTypeFactory().constructParametricType(ArrayList.class, listClass);
			return (List<T>)mapper.readValue(jsonString, javaType);
		} catch( NullPointerException e){
			LOGGER.info("无法将null转换成对象，将返回无数据的ArrayList");
			return new ArrayList<T>();
		} catch (IOException e) {
			throw new RuntimeException("JSON【"+jsonString+"】转对象时出错", e);
		}
	}

	public static <T> Map<String,T> toMap(Class<T> valueClass, String jsonString){
		try {
			JavaType javaType = mapper.getTypeFactory().constructParametricType(HashMap.class, String.class, valueClass);;
			return (Map<String,T>) mapper.readValue(jsonString, javaType);
		} catch( NullPointerException e){
			LOGGER.info("无法将null转换成对象，将返回无数据的HashMap");
			return new HashMap<String, T>();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("JSON【"+jsonString+"】转对象时出错", e);
		}
	}


	/**
	 * 用于对象通过其他工具已转为JSON的字符形式，这里不需要再加上引号
	 * @param obj
	 * @param isObject
	 */
	public static String getJsonSuccess(String obj, boolean isObject){
		String jsonString = null;
		if(obj == null){
			jsonString = "{\"success\":true}";
		}else{
			jsonString = "{\"success\":true,\"data\":"+obj+"}";
		}
		return jsonString;
	}
	
	public static String getJsonSuccess(Object obj){
		return getJsonSuccess(obj, null);
	}
	
	public static String getJsonSuccess(Object obj, String message) {
		if(obj == null){
			return "{\"success\":true,\"message\":\""+message+"\"}";
		}else{
			try{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("success", true);
				return "{\"success\":true,"+toString(obj)+",\"message\":\""+message+"\"}";
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
			}
		}
	}
	
	public static String getJsonError(Object obj){
		return getJsonError(obj, null);
	}
	
	public static String getJsonError(Object obj, String message) {
		if(obj == null){
			return "{\"success\":false,\"message\":\""+message+"\"}";
		}else{
			try{
				obj = parseIfException(obj);
				return "{\"success\":false,\"data\":"+toString(obj)+",\"message\":\""+message+"\"}";
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
			}
		}
	}
	
	public static Object parseIfException(Object obj){
		if(obj instanceof Exception){
			return getErrorMessage((Exception) obj, null);
		}
		return obj;
	}
	
	public static String getErrorMessage(Exception e, String defaultMessage){
		return defaultMessage != null ? defaultMessage : null;
	}
	
	public static ObjectMapper getMapper() {
		return mapper;
	}
}
