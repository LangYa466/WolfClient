package cn.langya.module.impl.render;

import cn.langya.Wolf;
import cn.langya.event.impl.player.EventAttack;
import cn.langya.event.impl.render.EventRender2D;
import cn.langya.module.Category;
import cn.langya.module.Module;
import cn.langya.ui.font.FontManager;
import cn.langya.util.impl.render.ColorUtils;
import cn.langya.util.impl.render.RenderUtil;
import cn.langya.util.impl.render.RoundedUtils;
import cn.langya.util.impl.render.ShadowUtil;
import com.cubk.event.annotations.EventTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

/**
 * @author LangYa
 * @date 2024/1/19 下午 08:26
 */

public class HUD extends Module {
    public HUD() {
        super("HUD", Category.Render);
    }


    @EventTarget
    void onA(EventAttack e) {
            drawTarget(e.entity.ticksExisted);
    }


    @EventTarget
    void onR2d(EventRender2D e) {
        // text

        RoundedUtils.drawRound(3,0,FontManager.C20.getStringWidth("狼牙客户端 |"+ Minecraft.getDebugFPS() +"帧"),FontManager.C20.FONT_HEIGHT,0, Color.BLACK);
        RoundedUtils.drawRound(3,0,FontManager.C20.getStringWidth("狼牙客户端 |"+ Minecraft.getDebugFPS() +"帧"),3,0, ColorUtils.color((int) e.partialTicks));
        FontManager.C20.drawString("狼牙客户端 |"+ Minecraft.getDebugFPS() +"帧", 5, 6, -1);

        // 游戏信息
        RoundedUtils.drawRound(0, 120, 130, 60, 0, new Color(49,49,49));
        RoundedUtils.drawRound(0, 120, 130, 15, 0, new Color(19,19,19));
        RoundedUtils.drawRound(0, 120, 130, 3, 0, ColorUtils.color((int) e.partialTicks));
        RenderUtil.resetColor();
        ShadowUtil.drawShadow(0, 120, 130, 60);

        FontManager.C25.drawCenteredString("信息",18, 123,-1);

        FontManager.C20.drawCenteredString("玩家名称",25, 138,-1);
        FontManager.C20.drawCenteredString(getPlayerName(),100, 138,-1);

        FontManager.C20.drawCenteredString("血量",15, 138 + FontManager.C20.FONT_HEIGHT - 5,-1);
        FontManager.C20.drawCenteredString(getPlayerHealth(),120, 138 + FontManager.C20.FONT_HEIGHT - 5,-1);

        FontManager.C20.drawCenteredString("击杀",15, 138 + FontManager.C20.FONT_HEIGHT - 5 + FontManager.C20.FONT_HEIGHT - 5,-1);
        FontManager.C20.drawCenteredString("0",120, 138 + FontManager.C20.FONT_HEIGHT - 5 + FontManager.C20.FONT_HEIGHT - 5,-1);

        if(mc.currentScreen instanceof GuiChat || mc.thePlayer.hurtTime > 0) {
            drawTarget((int) e.partialTicks);
        }




    }

    static void drawTarget(int ticks) {
        // 我
        GlStateManager.pushMatrix();
        GlStateManager.translate(50, 50, 0.0f);

        // draw rect
        RoundedUtils.drawRound(10, 10, 60 + mc.fontRendererObj.getStringWidth(mc.thePlayer.getName()), 28, 5, new Color(0,0,0,80));
        RenderUtil.resetColor();
        RoundedUtils.drawRound(40, 30,mc.thePlayer.getHealth() * 3f, 3, 1,ColorUtils.color(ticks));
        RenderUtil.resetColor();

        // draw head
        RenderUtil.drawBigHead(13.5f, 12.5f, 23.0f, 23.0f, mc.thePlayer);

        // draw string
        FontManager.T18.drawString(mc.thePlayer.getName(), 47f, 16.0f, -1);

        GlStateManager.resetColor();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    private String getPlayerHealth() {

        return ( (int) (mc.thePlayer.getHealth() / mc.thePlayer.getMaxHealth() * 100)) + "%";
    }

    private String getPlayerName() {
        String name;
        String playername = mc.thePlayer.getName();
        if(playername.length() > 11) {
            name = playername.substring(0, playername.length() - 3) + "??";
        } else {
            name = playername;
        }
        return name;
    }




}
