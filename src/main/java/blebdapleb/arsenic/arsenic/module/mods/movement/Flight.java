package blebdapleb.arsenic.arsenic.module.mods.movement;

import blebdapleb.arsenic.arsenic.event.EventTarget;
import blebdapleb.arsenic.arsenic.event.EventUpdate;
import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingBoolean;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingNumber;

public class Flight extends Module {
    public Flight() {
        super("Flight", KEY_UNBOUND, ModuleCategory.MOVEMENT, "Allows you to fly.");
    }

    @ArsenicSubscribe
    public void onTick(EventTick eventTick) {
        if (!isEnabled()) return;

        mc.player.getAbilities().allowFlying = true;
    }
}
