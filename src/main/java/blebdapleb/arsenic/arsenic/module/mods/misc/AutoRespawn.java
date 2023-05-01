package blebdapleb.arsenic.arsenic.module.mods.misc;

import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;

public class AutoRespawn extends Module {

    public AutoRespawn() {
        super("AutoRespawn", KEY_UNBOUND, ModuleCategory.MISC, "when died automatic respawn if u enable this module");
    }

    @ArsenicSubscribe
    public void onTick(EventTick eventTick) {
        if (mc.player.isDead() && mc.player.getHealth() <= 0) {
            mc.player.requestRespawn();
        }
    }
}
