package cn.langya.ui.screen.impl;

import cn.langya.Wolf;
import cn.langya.ui.font.FontManager;
import cn.langya.ui.screen.util.BestButton;
import cn.langya.util.impl.misc.TimeUtil;
import cn.langya.util.impl.render.RoundedUtils;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;

import java.awt.*;
import java.io.IOException;

/**
 * @author LangYa
 * @date 2024/1/21 下午 02:27
 */

public class GuiMainMenu extends GuiScreen {
    BestButton singlPlayerButton;
    BestButton multiPlayerButton;
    BestButton guiLoginButton;
    final Color bgcolor = new Color(0,0,0,150);
    final int width = 1280;
    final int height = 685;

    @Override
    public void initGui() {
        singlPlayerButton = new BestButton(width / 2 - 55,height / 2 - 140,160,30,bgcolor);
        multiPlayerButton = new BestButton(width / 2 - 55,height / 2 - 140 + 40,160,30,bgcolor);
        guiLoginButton = new BestButton(width / 2 - 55,height / 2 - 140 + 40 + 40,160,30,bgcolor);
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        // 绘制背景
        drawDefaultBackground();

        // 绘制标题
        FontManager.T50.drawCenteredString(Wolf.name,width / 2 + 23 ,height / 2 - 180,-1);

        // 绘制小背景
        RoundedUtils.drawRound(width / 2 - 100,height / 2 - 200,height / 2 - 100,width / 2 - 300,8,new Color(255,255,255,20));

        // 绘制
        singlPlayerButton.draw(mouseX,mouseY);
        multiPlayerButton.draw(mouseX,mouseY);
        guiLoginButton.draw(mouseX,mouseY);
        FontManager.C30.drawCenteredStringWithShadow("单人游戏",sr.getScaledWidth() - (width / 2 - 55 + width) + 130,height / 2 - 140 + 5,-1);
        FontManager.C30.drawCenteredStringWithShadow("多人游戏",sr.getScaledWidth() - (width / 2 - 55 + width) + 130,height / 2 - 140 + 40 + 5,-1);
        FontManager.C30.drawCenteredStringWithShadow("登录测试",sr.getScaledWidth() - (width / 2 - 55 + width) + 130,height / 2 - 140 + 40 + 40 + 5,-1);

        // 绘制时间文本
        FontManager.T50.drawCenteredString(TimeUtil.getTime(),1200,20,-1);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (singlPlayerButton.hoverFade >0){
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }

        if (multiPlayerButton.hoverFade >0){
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }

        if (guiLoginButton.hoverFade >0){
            mc.displayGuiScreen(new GuiLogin());
        }


        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
