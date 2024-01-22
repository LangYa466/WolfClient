package cn.langya;

import cn.langya.module.ModuleManager;
import cn.langya.module.impl.client.Client;
import cn.langya.module.impl.move.AutoSprint;
import cn.langya.module.impl.player.HackerDetector;
import cn.langya.ui.font.FontManager;
import cn.langya.ui.screen.impl.GuiMainMenu;
import cn.langya.util.impl.misc.ClientUtil;
import com.cubk.event.EventManager;
import de.florianmichael.viamcp.ViaMCP;
import net.minecraft.client.Minecraft;

/**
 * @author LangYa
 * @date 2024/1/19 下午 04:37
 */

public class Wolf {

    public static final String name = "Wolf";
    public static final String author = "LangYa";
    public static final String version = "1.0";

    // Manager
    public static EventManager eventManager;
    public static ModuleManager moduleManager;

    public static void initClient() {
        ClientUtil.loginfo("加载中...");

        FontManager.initFonts();
        eventManager = new EventManager();
        moduleManager = new ModuleManager();

        try {
            ViaMCP.create();

            ViaMCP.INSTANCE.initAsyncSlider();
            ViaMCP.INSTANCE.initAsyncSlider(10, 7, 70, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClientUtil.loginfo("加载完毕!!");

        Minecraft.getMinecraft().displayGuiScreen(new GuiMainMenu());
    }

}
