package com.dvt.elementui.common.datadict;

import com.dvt.elementui.common.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/code")
public class DataDictController {

    @Autowired
    private DataDictLoader dataDictLoader;

    @PostMapping("/type")
    public Result loadDataDict(@RequestBody List<String> codeTypes) {
        Map<String, Map<String, String>> dataDict = new HashMap<String, Map<String, String>>();
        for (String codeType : codeTypes) {
            Collection<CodeData> codeData = dataDictLoader.getOneType(codeType);
            dataDict.put(codeType, toMap(codeData));
        }
        return Result.ok(dataDict);
    }

    private Map<String, String> toMap(Collection<CodeData> codeData) {
        Map<String, String> map = new HashMap<String, String>();
        for (CodeData data : codeData) {
            map.put(data.getCodeValue(), data.getCodeName());
        }
        return map;
    }
}
