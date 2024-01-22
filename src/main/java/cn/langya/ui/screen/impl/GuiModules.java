package cn.langya.ui.screen.impl;

import cn.langya.Wolf;
import cn.langya.module.Module;
import cn.langya.ui.font.FontManager;
import cn.langya.ui.screen.util.BestButton;
import cn.langya.util.impl.render.RoundedUtils;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;

/**
 * @author LangYa
 * @date 2024/1/21 下午 10:20
 */

public class GuiModules extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        for(final Module modules : Wolf.moduleManager.modules) {
          //  new BestButton(90f,90f,20f,20f, new Color(0,0,0,80)).draw(modules.name, FontManager.T15,mouseX,mouseY);
        }


        super.drawScreen(mouseX, mouseY, partialTicks);
    }




}

