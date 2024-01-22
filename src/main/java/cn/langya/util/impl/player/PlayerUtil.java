package cn.langya.util.impl.player;

import cn.langya.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:24
 */

public class PlayerUtil extends Util {

    public static void addMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("§a[狼牙客户端] §r" + message));
    }

}
