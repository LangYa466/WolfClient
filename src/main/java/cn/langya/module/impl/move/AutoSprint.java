package cn.langya.module.impl.move;

import cn.langya.event.impl.player.EventUpdatePlayer;
import cn.langya.module.Category;
import cn.langya.module.Module;
import com.cubk.event.annotations.EventTarget;
import org.lwjgl.input.Keyboard;

/**
 * @author LangYa
 * @date 2024/1/21 下午 03:35
 */

public class AutoSprint extends Module {

    public AutoSprint() {
        super("自动疾跑", Category.Move, Keyboard.KEY_X);
    }

    @EventTarget
    void onUpdate(EventUpdatePlayer e) {
        mc.thePlayer.setSprinting(true);
    }

}
