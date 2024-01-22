package cn.langya.ui.font;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;

import java.awt.*;
import java.util.ArrayList;

public abstract class FontManager {
    public static ArrayList<Font> fonts = new ArrayList<Font>();

    // SFUI
    public static FontDrawer S15;
    public static FontDrawer S20;
    public static FontDrawer S25;
    public static FontDrawer S30;
    public static FontDrawer S50;
    // 原神字体
    public static FontDrawer C15;
    public static FontDrawer C20;
    public static FontDrawer C25;
    public static FontDrawer C30;
    //Round 太帅了我滴妈
    public static FontDrawer T15;
    public static FontDrawer T18;
    public static FontDrawer T20;
    public static FontDrawer T25;
    public static FontDrawer T30;
    public static FontDrawer T50;

    public static void initFonts() {
        LogManager.getLogger().info("[字体系统] 加载字体中..");

        S15 = getFont("sfui.ttf", 15, true);
        S20 = getFont("sfui.ttf", 20, true);
        S25 = getFont("sfui.ttf", 25, true);
        S30 = getFont("sfui.ttf", 30, true);
        S50 = getFont("sfui.ttf", 50, true);

        C15 = getFont("genshin.ttf", 15, true);
        C20 = getFont("genshin.ttf", 20, true);
        C25 = getFont("genshin.ttf", 25, true);
        C30 = getFont("genshin.ttf", 30, true);

        T15 = getFont("tenacity.ttf", 15, true);
        T18 = getFont("tenacity.ttf", 18, true);
        T20 = getFont("tenacity.ttf", 20, true);
        T25 = getFont("tenacity.ttf", 25, true);
        T30 = getFont("tenacity.ttf", 30, true);
        T50 = getFont("tenacity.ttf",50,true);
        LogManager.getLogger().info("[字体系统] 一共加载了 " + fonts.size() + "个字体");

    }

    public static FontDrawer getFont(String name, int size, boolean antiAliasing) {
        Font font;
        try {
            font = Font.createFont(0, Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("wolfclient/fonts/" + name)).getInputStream()).deriveFont(Font.PLAIN, (float) size);
            fonts.add(font);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error loading font");
            font = new Font("default", Font.PLAIN, size);
        }
        return new FontDrawer(font, antiAliasing);
    }

}
