package cn.langya.event.impl.render;

import com.cubk.event.impl.Event;

/**
 * @author LangYa
 * @date 2024/1/19 下午 05:17
 */

public class EventRender3D implements Event {
    public float ticks;
    public EventRender3D(final float ticks) {
        this.ticks = ticks;
    }
}
