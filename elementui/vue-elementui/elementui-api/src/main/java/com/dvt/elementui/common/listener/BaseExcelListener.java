package com.dvt.elementui.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;

import java.util.List;
/**
 *
 * @Author lij
 * @Description 监听类，可以自定义
 * @Date 2019-01-24
 * @Time 15.00
 */
public class BaseExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = Lists.newArrayList();

    @Override
    public void invoke(Object object, AnalysisContext analysisContext) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        datas.add(object);
        //根据业务自行 do something
        doSomething();

        /***
            如数据过大，可以进行定量分批处理
            if(datas.size()<=100){
                datas.add(object);
            }else {
                doSomething();
                datas = new ArrayList<Object>();
            }
        */
    }

    /**
     * 根据业务自行实现该方法
     */
    private void doSomething() {
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        /*
            datas.clear();
            解析结束销毁不用的资源
         */
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
