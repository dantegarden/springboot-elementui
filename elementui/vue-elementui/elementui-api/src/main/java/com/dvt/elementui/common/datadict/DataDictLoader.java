package com.dvt.elementui.common.datadict;

import java.util.Collection;

public interface DataDictLoader {

    void preLoad();

    Collection<CodeData> getOneType(String codeType);

    Collection<CodeData> getOneType(String codeType, String[] codeKeys);

    String getCodeName(String codeType, String codeValue);
}
