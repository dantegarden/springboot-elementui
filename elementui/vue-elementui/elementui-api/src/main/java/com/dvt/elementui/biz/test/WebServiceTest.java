package com.dvt.elementui.biz.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

public class WebServiceTest {

    @Test
    public void test() throws Exception {
        String wsdlUrl = "http://localhost:8088/ws/user?wsdl";
        JaxWsDynamicClientFactory dcflient = JaxWsDynamicClientFactory.newInstance();
        Client client = dcflient.createClient(wsdlUrl);
        Object[] objects = client.invoke("getUser",10010);
        System.out.println("*******" + objects[0].toString());
    }
}
