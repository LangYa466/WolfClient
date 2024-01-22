package cn.langya.event.impl.player;

import com.cubk.event.impl.Event;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * @author LangYa
 * @date 2024/1/19 下午 09:47
 */

public class EventAttack implements Event {
    public EntityLivingBase entity;

    public EventAttack(final EntityLivingBase entity) {
        this.entity = entity;
    }
}
