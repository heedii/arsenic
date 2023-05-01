package blebdapleb.arsenic.arsenic.module.mods.movement;

import blebdapleb.arsenic.arsenic.event.EventTarget;
import blebdapleb.arsenic.arsenic.event.EventUpdate;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;

public class Flight extends Module {
    public Flight() {
        super("Flight", KEY_UNBOUND, ModuleCategory.MOVEMENT, "Allows you to fly.");
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        mc.player.getAbilities().flying = true;
    }
}
