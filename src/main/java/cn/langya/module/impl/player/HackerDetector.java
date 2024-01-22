package cn.langya.module.impl.player;

import cn.langya.event.impl.world.EventPacketReceive;
import cn.langya.module.Category;
import cn.langya.module.Module;
import cn.langya.util.impl.player.PlayerUtil;
import cn.langya.value.impl.BoolValue;
import com.cubk.event.annotations.EventTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.util.EnumChatFormatting;

/**
 * @author LangYa
 * @date 2024/1/20 下午 12:26
 */

public class HackerDetector extends Module {

    public HackerDetector() {
        super("黑客检测器", Category.Player);
        add(noslowAValue, velocityValue);
    }

    public BoolValue noslowAValue = new BoolValue("NoSlowA", true);
    public BoolValue velocityValue = new BoolValue("Velocity", true);
    static String prefix = "[黑客检测器] ";

    @EventTarget
    public void onPacket(EventPacketReceive event) {

        if(mc.thePlayer == null || mc.theWorld == null) {
            return;
        }

        if (mc.thePlayer.ticksExisted % 6 == 0) {
            if (event.getPacket() instanceof S14PacketEntity && noslowAValue.getValue()) {
                S14PacketEntity packet = (S14PacketEntity) event.getPacket();
                Entity entity = packet.getEntity(mc.theWorld);
                if (!(entity instanceof EntityPlayer)) {
                    return;
                }
                new Thread(() -> checkPlayer((EntityPlayer) entity)).start();
            }
        }
    }

    private void checkPlayer(EntityPlayer player) {
        if (player.equals(mc.thePlayer)) {
            return;
        }
        if (player.isUsingItem() && (player.posX - player.lastTickPosX > 0.2 || player.posZ - player.lastTickPosZ > 0.2) && noslowAValue.getValue()) {
            PlayerUtil.addMessage(prefix + player.getName() + "触发了 无减速");
        }

        if (player.motionY >= 0 && player.hurtTime > 0 && velocityValue.getValue()) {
            PlayerUtil.addMessage(prefix + player.getName() + "触发了 防击退");
        }

        boolean rotationspeed = false;
        int killauravl = 0;
        for (int i = player.hurtTime; i >= 1; i--) {
            if (Math.abs(player.prevRotationYaw - player.rotationYaw) >= 180.0) {
                rotationspeed = true;
                ++killauravl;
                break;
            }
        }

        if (rotationspeed && killauravl >= 3) {
            PlayerUtil.addMessage(prefix + EnumChatFormatting.AQUA + "触发了 杀戮光环");
        }


    }


}
