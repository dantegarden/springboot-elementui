package com.dvt.elementui.common.enums;


/**
 * boolean枚举，YES/NO
 *
 * @author dazzlzy
 * @date 2018/5/7
 */
public enum BooleanEnum {

    /**
     * YES: 1
     */
    YES(1),

    /**
     * NO: 0
     */
    NO(0);

    private int value;

    BooleanEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
