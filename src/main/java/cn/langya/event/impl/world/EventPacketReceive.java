
package cn.langya.event.impl.world;

import com.cubk.event.impl.Cancellable;
import com.cubk.event.impl.Event;
import net.minecraft.network.*;

public class EventPacketReceive implements Event, Cancellable
{
    public Packet<?> packet;
    private final EnumPacketDirection direction;
    private final INetHandler netHandler;
    
    public EventPacketReceive(final Packet<?> packet, final EnumPacketDirection direction, final INetHandler netHandler) {
        this.packet = packet;
        this.direction = direction;
        this.netHandler = netHandler;
    }
    
    public Packet<?> getPacket() {
        return this.packet;
    }
    
    public EnumPacketDirection getDirection() {
        return this.direction;
    }
    
    public INetHandler getNetHandler() {
        return this.netHandler;
    }
    
    public void setPacket(final Packet<?> packet) {
        this.packet = packet;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {
        setPacket(null);
    }
}
