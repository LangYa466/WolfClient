package cn.langya.module.impl.render;

import cn.langya.module.Category;
import cn.langya.module.Module;
import cn.langya.ui.screen.impl.GuiLogin;
import org.lwjgl.input.Keyboard;

/**
 * @author LangYa
 * @date 2024/1/21 下午 10:23
 */

public class ClickGui extends Module {

    public ClickGui() {
        super("ClickGui", Category.Client, Keyboard.KEY_Z);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(new GuiLogin());
        super.onEnable();
    }
}

