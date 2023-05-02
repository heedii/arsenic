package blebdapleb.arsenic.arsenic.module.mods.combat;

import blebdapleb.arsenic.arsenic.event.EventTarget;
import blebdapleb.arsenic.arsenic.event.events.EventReceivePacket;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingNumber;
import blebdapleb.arsenic.arsenic.util.ReflectionHelper;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;

public class Velocity extends Module {
    public Velocity() {
        super("Velocity", KEY_UNBOUND, ModuleCategory.COMBAT, "No Knockback",
        new SettingNumber("Horizontal", -100, 200, 1, 1),
        new SettingNumber("Vertical", -100, 200, 2, 1)
        );
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket event) {
        if(mc.world == null || mc.player == null) return;
        if(event.getPacket() instanceof EntityVelocityUpdateS2CPacket) {
            EntityVelocityUpdateS2CPacket velocity = (EntityVelocityUpdateS2CPacket) event.getPacket();
            if(velocity.getId() == mc.player.getId() && !mc.player.isTouchingWater()) {
                //ReflectionHelper.setPrivateValue(EntityVelocityUpdateS2CPacket.class, velocity, (int) (velocity.getVelocityX() + ))
            }
        }
    }
}
