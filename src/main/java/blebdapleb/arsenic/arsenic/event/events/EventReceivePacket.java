package blebdapleb.arsenic.arsenic.event.events;

import blebdapleb.arsenic.arsenic.event.Event;
import net.minecraft.network.packet.Packet;

public class EventReceivePacket extends Event {

    private Packet<?> packet;

    public EventReceivePacket(Packet<?> packet) {
        this.packet = packet;
    }

    public Packet<?> getPacket() {
        return packet;
    }
}