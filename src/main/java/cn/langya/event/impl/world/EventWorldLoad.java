package cn.langya.event.impl.world;

import com.cubk.event.impl.Event;
import net.minecraft.client.multiplayer.WorldClient;

/**
 * @author LangYa
 * @date 2024/1/20 下午 12:30
 */

public class EventWorldLoad implements Event {
    public WorldClient worldClient;

    public EventWorldLoad(final WorldClient worldClient) {
        this.worldClient = worldClient;
    }

}
