package cn.langya.module;

import cn.langya.Wolf;
import cn.langya.util.Util;
import cn.langya.value.Value;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:10
 */

public class Module extends Util {

    public String name;
    public Category category;
    public boolean state;
    public int keyCode;

    public static final Minecraft mc = Minecraft.getMinecraft();

    public List<Value> values = new ArrayList<>();
    public void add(Value... value) {
        values = Arrays.asList(value);
    }

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Module(String name, Category category,int Keycode) {
        this.name = name;
        this.category = category;
        this.keyCode = Keycode;
    }

    public void onEnable() {}
    public void onDisable() {}

    public void toggle(){
        setState(!state);
    }

    public void setState(boolean value) {
        if (state == value) return;

        if (value) {
            Wolf.eventManager.register(this);
            onEnable();
        } else {
            Wolf.eventManager.unregister(this);
            onDisable();
        }


        state = value;
    }

}
