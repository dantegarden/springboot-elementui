package com.dvt.elementui.common.datadict;

public class CodeData {

    private String codeName;
    private String codeValue;

    public CodeData() {
    }

    public CodeData(String codeName, String codeValue) {
        this.codeName = codeName;
        this.codeValue = codeValue;
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeValue() {
        return this.codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
}
