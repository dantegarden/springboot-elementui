package com.dvt.elementui.common.datadict;

import com.dvt.elementui.biz.model.SysCode;

import java.util.Collection;
import java.util.List;

public interface DataDict {

    public void addAll(List<SysCode> dataDict);

    public Collection<CodeData> getOneType(String codeType);

    public CodeData getUniqueOne(String codeType, String codeKey);

    public String getCodeName(String codeType, String codeValue);

    public String getCodeVal(String codeType, String codeKey);

    /**
     * 获取同一类型指定key的一组值
     * @param codeType
     * @param codeKeys
     * @return
     */
    public List<String> getCodeValList(String codeType, String... codeKeys);
}
