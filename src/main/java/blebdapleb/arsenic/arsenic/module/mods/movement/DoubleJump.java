/*package blebdapleb.arsenic.arsenic.module.mods.movement;

import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingMode;
import net.minecraft.block.Blocks;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class DoubleJump extends Module {

    public DoubleJump() {
        super("Double Jump", KEY_UNBOUND ,ModuleCategory.MOVEMENT, "Makes you able to Double Jump",
            new SettingMode("Mode", "Hypixel", "Hypixel", "Packet", "Mineplex", "Teleport", "NoBypasses")
        );
    }

    @ArsenicSubscribe
    public void onTick(EventTick event) {
        if (isEnabled()) {
            if (mc.player.isOnGround() == false && getSetting(0).asMode().isMode("NoBypasses")) {
                mc.player.isOnGround() = true;
            }
            if (mc.player.isOnGround() == false && getSetting(0).asMode().isMode("Packet")) {
                //mc.player.isOnGround() = true;
                mc.player.sendQueue(); //this will be packet but rn not working because im not in intellij idea
            }
        }
    }

}*/
