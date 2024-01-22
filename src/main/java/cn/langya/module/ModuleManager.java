package cn.langya.module;

import cn.langya.Wolf;
import cn.langya.event.impl.misc.EventKey;
import cn.langya.module.impl.client.Client;
import cn.langya.module.impl.move.AutoSprint;
import cn.langya.module.impl.player.HackerDetector;
import cn.langya.module.impl.render.ClickGui;
import cn.langya.module.impl.render.HUD;
import cn.langya.util.impl.misc.ClientUtil;
import com.cubk.event.annotations.EventTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:10
 */

public class ModuleManager {
    public static final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        registerModule(new Client());
        registerModule(new HUD());
        registerModule(new HackerDetector());
        registerModule(new AutoSprint());
        registerModule(new ClickGui());
        Wolf.eventManager.register(this);
        ClientUtil.loginfo("[模块系统] 一共加载了" + modules.size() + "个模块!!!");
    }

    private void registerModule(Module module) {
        modules.add(module);
        ClientUtil.loginfo("[模块系统]" + module.name + "注册成功!!!");
    }

    @EventTarget
    void onK(EventKey e) {
        for (Module module : modules) {
            if (module.keyCode == e.keyCode) {
                module.toggle();
            }
        }
    }



}
