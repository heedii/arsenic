package blebdapleb.arsenic.arsenic.module.mods.combat;

import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingBoolean;
import blebdapleb.arsenic.arsenic.util.player.PlayerUtils;

public class Surround extends Module {
    public Surround() {
        super("Surround", KEY_UNBOUND, ModuleCategory.COMBAT, "hvh momento",
        new SettingBoolean("Rotations", true),
        new SettingBoolean("NoAirPlace", false),
        new SettingBoolean("Double", false),
        new SettingBoolean("SelfTrap", false),
        new SettingBoolean("SelfAnvil", false),
        new SettingBoolean("AntiCev", false),
        new SettingBoolean("CheckEntity", true),
        new SettingBoolean("OnlyGround", true),
        new SettingBoolean("Center", true),
        new SettingBoolean("DisableOnJump", true),
        new SettingBoolean("DisableOnYChange", true)
        );
    }
    @ArsenicSubscribe
    private void onTick(EventTick eventTick) {
        if(this.getSetting(9).asBoolean().isEnabled()) {
            mc.options.jumpKey.isPressed();
            toggle();
        }
    }

    @Override
    public void onEnable(boolean inWorld) {
        if(this.getSetting(8).asBoolean().isEnabled()) {
            PlayerUtils.centerPlayer();
        }

        if(this.getSetting(2).asBoolean().isEnabled()) {
            
        }
    }
}
