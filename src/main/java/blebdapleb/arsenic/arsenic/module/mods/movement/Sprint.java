package blebdapleb.arsenic.arsenic.module.mods.movement;

import blebdapleb.arsenic.arsenic.event.EventTarget;
import blebdapleb.arsenic.arsenic.event.EventUpdate;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", KEY_UNBOUND, ModuleCategory.MOVEMENT, "Allows you to sprint.");
    }
    @EventTarget
    public void onUpdate(EventUpdate e) {
        mc.player.setSprinting(true);
    }
}
