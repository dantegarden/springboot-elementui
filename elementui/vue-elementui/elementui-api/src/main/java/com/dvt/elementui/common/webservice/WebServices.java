package com.dvt.elementui.common.webservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dvt.elementui.common.bean.TypedResult;
import com.dvt.elementui.common.exception.BusinessException;
import com.dvt.elementui.common.properties.WebServiceProperties;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


@Component
public class WebServices {

    private static final Logger LOGGER = Logger.getLogger(WebServices.class);

    @Autowired
    private WebServiceProperties webServiceProperties;

    private static JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
    private Map<String, Client> clients = new HashMap<String, Client>();
    private static final long DEFAULT_CONNECTION_TIMEOUT = 30000;
    private static final long DEFAULT_RECEIVE_TIMEOUT = 15000;

    private static final String ERR_MSG = "调用WebService时发生错误";
    private static final String NULL_MSG = "调用WebService返回结果为空";
    private final TypedResult<?> nullResp = TypedResult.fail(NULL_MSG);
    private final TypedResult<?> errResp = new TypedResult(ERR_MSG);


    public void initClients(){
        List<Map<String, String>> configs = webServiceProperties.getConfig();
        if(CollectionUtils.isNotEmpty(configs)){
            for(Map<String, String> config: configs){
                String serviceName = config.get("name");
                String wsdlUrl = config.get("wsdlUrl");
                String connectionTimeout = config.get("connectionTimeout");
                String receiveTimeout = config.get("receiveTimeout");
                if(StringUtils.isBlank(serviceName) || StringUtils.isBlank(wsdlUrl)){
                    throw new BusinessException("未配置WebService服务名或WSDL服务地址");
                }

                Client client = dcf.createClient(wsdlUrl);
                HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
                HTTPClientPolicy policy = new HTTPClientPolicy();
                policy.setConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT);
                policy.setReceiveTimeout(DEFAULT_RECEIVE_TIMEOUT);
                if(connectionTimeout!=null){
                    policy.setConnectionTimeout(Long.valueOf(connectionTimeout)); //连接超时时间
                }
			    if(receiveTimeout!=null){
                    policy.setReceiveTimeout(Long.valueOf(receiveTimeout)); //连接超时时间
                }
                httpConduit.setClient(policy);
                clients.put(serviceName, client);
                LOGGER.info("已加载WebService服务：" + serviceName);
            }
        }else{
            LOGGER.info("没有可初始化的WebService");
        }
    }

    private Client initClient(String serviceName) {
        Client client = clients.get(serviceName);
        if (client == null) {
            List<Map<String, String>> configs = webServiceProperties.getConfig();
            if(CollectionUtils.isNotEmpty(configs)){
                for(Map<String, String> config: configs){
                    if(serviceName.equals(config.get("name"))){
                        String wsdlUrl = config.get("wsdlUrl");
                        String connectionTimeout = config.get("connectionTimeout");
                        String receiveTimeout = config.get("receiveTimeout");
                        if(StringUtils.isBlank(wsdlUrl)){
                            throw new BusinessException("未配置WebService的WSDL服务地址");
                        }

                        client = dcf.createClient(wsdlUrl);
                        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
                        HTTPClientPolicy policy = new HTTPClientPolicy();
                        policy.setConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT);
                        policy.setReceiveTimeout(DEFAULT_RECEIVE_TIMEOUT);
                        if(connectionTimeout!=null){
                            policy.setConnectionTimeout(Long.valueOf(connectionTimeout)); //连接超时时间
                        }
                        if(receiveTimeout!=null){
                            policy.setReceiveTimeout(Long.valueOf(receiveTimeout)); //连接超时时间
                        }
                        httpConduit.setClient(policy);
                        clients.put(serviceName, client);
                        break;
                    }
                }
            }
        }
        return client;
    }

    /**
     * 调用WebServices方法
     * @param serviceName WebServices服务名(对应yml里的name)
     * @param methodName 调用的方法名
     * @param params 参数
     * @return json字符串
     * @throws Exception
     */
    public String invoke(String serviceName, String methodName, Object... params) throws Exception {
        Client client = initClient(serviceName);
        String result = "";
        if(client!=null){
            return (String) client.invoke(methodName, params)[0];
        }else{
            throw new BusinessException("没有找到这个WebService服务");
        }
    }

    public <T> TypedResult<T> doInvokeWebService(String serviceName, String methodName , TypeReference<T> dataType, Object... params){
        String invokeResult = null;
        try{
            invokeResult = this.invoke(serviceName,methodName,params);
            return parseResult(invokeResult, dataType) ;
        }catch (Exception e){
            LOGGER.error(ERR_MSG,e);
            e.printStackTrace();
            return (TypedResult<T>) errResp;
        }
    }

    private <T> TypedResult<T> parseResult(String invokeResult,TypeReference<T> dataTypeToken){
        if(invokeResult==null){
            return (TypedResult<T>) nullResp;
        }

        TypedResult<T> result = TypedResult.ok(JSON.parseObject(invokeResult, dataTypeToken));
        return result;
    }
}
