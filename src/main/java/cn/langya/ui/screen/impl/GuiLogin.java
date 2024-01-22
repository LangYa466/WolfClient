package cn.langya.ui.screen.impl;

import cn.langya.ui.font.FontManager;
import cn.langya.ui.screen.util.BestInput;
import cn.langya.ui.screen.util.CustomTextField;
import cn.langya.util.impl.render.RoundedUtils;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;

/**
 * @author LangYa
 * @date 2024/1/21 下午 02:27
 */

public class GuiLogin extends GuiScreen {
    BestInput username;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        // draw rect
        RoundedUtils.drawRound(0,0,200,sr.getScaledHeight(),2,new Color(0,0,0,80));
        FontManager.S50.drawCenteredStringWithShadow("GuiLogin",100,2,-1);
        username.draw("输入您的用户名",FontManager.C20,Color.white,mouseX,mouseY);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        username = new BestInput(20,50,50,20,new Color(0,0,0,30));
        super.initGui();
    }
}
