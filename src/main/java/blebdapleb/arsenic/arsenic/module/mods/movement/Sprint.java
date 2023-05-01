package blebdapleb.arsenic.arsenic.module.mods.movement;

import blebdapleb.arsenic.arsenic.event.EventTarget;
import blebdapleb.arsenic.arsenic.event.EventUpdate;
import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", KEY_UNBOUND, ModuleCategory.MOVEMENT, "Allows you to sprint.");
    }
    @ArsenicSubscribe
    public void onTick(EventTick eventTick) {
        if (!isEnabled()) return;
        if (mc.options.forwardKey.isPressed()) mc.player.setSprinting(true);
        if (mc.options.leftKey.isPressed()) mc.player.setSprinting(true);
        if (mc.options.rightKey.isPressed()) mc.player.setSprinting(true);
        if (mc.options.backKey.isPressed()) mc.player.setSprinting(true);
    }
}
