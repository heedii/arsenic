package blebdapleb.arsenic.arsenic.module.mods.movement;

import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.Setting;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingBoolean;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingMode;

public class Flight extends Module {
    public Flight() {
        super("Flight", KEY_UNBOUND, ModuleCategory.MOVEMENT, "Allows you to fly.",
        new SettingMode("Mode", "Vanilla", "Vanilla", "Jetpack")
        //new SettingBoolean("NoFall", false)
        );
    }

    @ArsenicSubscribe
    public void onTick(EventTick eventTick) {
        if (getSetting(0).asMode().getMode() == "Vanilla") {
            if (!isEnabled()) return;
            mc.player.getAbilities().allowFlying = true;
        } else {
            if (mc.options.jumpKey.isPressed() && !mc.options.sneakKey.isPressed())
                mc.player.setVelocity(0, 0.42f, 0);
        }
    }
}
