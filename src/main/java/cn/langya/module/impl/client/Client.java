package cn.langya.module.impl.client;

import cn.langya.event.impl.player.EventAttack;
import cn.langya.event.impl.player.EventUpdatePlayer;
import cn.langya.module.Category;
import cn.langya.module.Module;
import cn.langya.util.impl.player.PlayerUtil;
import cn.langya.value.impl.BoolValue;
import com.cubk.event.annotations.EventTarget;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import org.lwjgl.input.Keyboard;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:38
 */

public class Client extends Module {

    public static final BoolValue languageReloadFix = new BoolValue("语言重载修复", true);
    public static final BoolValue inputFix = new BoolValue("中文输入", true);

    public Client() {
        super("客户端", Category.Client);
    }

    @EventTarget
    void onUpdate(EventUpdatePlayer e) {
        mc.leftClickCounter = 0;
        mc.rightClickDelayTimer = 0;
    }

    @EventTarget
    void onA(EventAttack e) {
    }

    public static boolean inputPatch() {
        return Keyboard.getEventKeyState() || (Keyboard.getEventKey() == 0 && Character.isDefined(Keyboard.getEventCharacter()));
    }

}
