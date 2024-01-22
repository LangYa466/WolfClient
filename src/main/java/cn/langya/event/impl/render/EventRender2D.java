package cn.langya.event.impl.render;

import com.cubk.event.impl.Event;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:17
 */

public class EventRender2D implements Event {

    public float partialTicks;

    public EventRender2D(final float partialTicks) {
        this.partialTicks = partialTicks;
    }

}
