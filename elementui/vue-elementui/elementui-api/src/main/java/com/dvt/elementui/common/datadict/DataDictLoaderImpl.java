package com.dvt.elementui.common.datadict;

import com.dvt.elementui.biz.dao.SysCodeDao;
import com.dvt.elementui.biz.model.SysCode;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class DataDictLoaderImpl extends BaseServiceImpl implements DataDictLoader {

    @Autowired
    private DataDict dataDict;
    @Autowired
    private SysCodeDao codeDao;

    @Override
    public void preLoad() {

        List<SysCode> codes = codeDao.queryCodes();
        dataDict.addAll(codes);
        //可以在这里再加非sys_code表的字典
    }

    @Override
    public Collection<CodeData> getOneType(String codeType) {
        return dataDict.getOneType(codeType);
    }

    @Override
    public Collection<CodeData> getOneType(String codeType, String[] codeKeys) {
        Collection<CodeData> codeList = Lists.newArrayList();

        for (CodeData codeData : this.getOneType(codeType)) {
            if(Arrays.asList(codeKeys).contains(codeData.getCodeValue())){
                codeList.add(codeData);
            }
        }
        return codeList;
    }

    @Override
    public String getCodeName(String codeType, String codeValue) {
        return dataDict.getCodeName(codeType, codeValue);
    }
}
