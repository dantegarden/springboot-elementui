package com.dvt.elementui.common.datadict;

import com.dvt.elementui.biz.model.SysCode;
import com.dvt.elementui.common.base.BaseServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataDictImpl extends BaseServiceImpl implements DataDict {

    private static Map<String, LinkedHashMap<String, CodeData>> codes = Maps.newHashMap();

    @Override
    public void addAll(List<SysCode> codes) {
        for (SysCode code : codes) {
            addOne(code);
        }
    }

    protected void addOne(SysCode oneCode) {
        CodeData data = new CodeData();
        BeanUtils.copyProperties(oneCode, data);

        String codeType = oneCode.getCodeType();
        LinkedHashMap<String, CodeData> codeMap = codes.get(codeType);
        if (codeMap == null) {
            codeMap = new LinkedHashMap<String, CodeData>();
            codeMap.put(oneCode.getCodeKey(), data);
            codes.put(codeType, codeMap);
        } else {
            codeMap.put(oneCode.getCodeKey(), data);
        }
    }

    @Override
    public Collection<CodeData> getOneType(String codeType) {
        return codes.get(codeType).values();
    }

    @Override
    public CodeData getUniqueOne(String codeType, String codeKey) {
        return codes.get(codeType).get(codeKey);
    }

    @Override
    public String getCodeName(String codeType, String codeValue) {
        Collection<CodeData> codeList = this.getOneType(codeType);
        for (CodeData codeData : codeList) {
            if(codeData.getCodeValue().equals(codeValue)) {
                return codeData.getCodeName();
            }
        }
        return "";
    }

    @Override
    public String getCodeVal(String codeType, String codeKey) {
        return this.getUniqueOne(codeType, codeKey).getCodeValue();
    }

    @Override
    public List<String> getCodeValList(String codeType, String... codeKeys) {
        List<String> resultStrs = Lists.newArrayList();
        if(codeKeys==null){
            return this.getAllValue(codeType);
        }
        for (String key : codeKeys) {
            resultStrs.add(getCodeVal(codeType, key));
        }
        return resultStrs;
    }

    public List<String> getAllValue(String codeType) {
        Collection<CodeData> cdList =  this.getOneType(codeType);
        List resultVals = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(cdList)){
            for (CodeData cd : cdList) {
                resultVals.add(cd.getCodeValue());
            }
        }else{
            throw new NullPointerException("Can't find this codeType from code");
        }
        return resultVals;
    }
}
