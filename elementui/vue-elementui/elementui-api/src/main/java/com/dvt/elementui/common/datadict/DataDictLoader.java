package com.dvt.elementui.common.datadict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface DataDictLoader {

    void preLoad();

    Collection<CodeData> getOneType(String codeType);

    Collection<CodeData> getOneType(String codeType, String[] codeKeys);

    String getCodeName(String codeType, String codeValue);
}
