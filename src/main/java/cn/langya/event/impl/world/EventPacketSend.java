package cn.langya.event.impl.world;

import com.cubk.event.impl.Cancellable;
import com.cubk.event.impl.Event;
import net.minecraft.network.*;

public class EventPacketSend implements Event,Cancellable {
    public Packet packet;
    
    public EventPacketSend(final Packet packet) {
        this.packet = packet;
    }
    
    public Packet getPacket() {
        return this.packet;
    }
    
    public void setPacket(final Packet packet) {
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
