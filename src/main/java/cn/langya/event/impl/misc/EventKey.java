package cn.langya.event.impl.misc;

import com.cubk.event.impl.Event;

/**
 * @author LangYa
 * @date 2024/1/21 下午 10:27
 */

public class EventKey implements Event {
    public int keyCode;

    public EventKey(int keyCode) {
        this.keyCode = keyCode;
    }
}
