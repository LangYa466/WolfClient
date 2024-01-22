package cn.langya.value.impl;

import cn.langya.value.Value;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:57
 */

public class BoolValue extends Value {

    private final String name;
    private final boolean value;

    public BoolValue(String name, boolean value) {
        super(name,value);
        this.name = name;
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
