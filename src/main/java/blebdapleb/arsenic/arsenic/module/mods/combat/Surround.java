package blebdapleb.arsenic.arsenic.module.mods.combat;

import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingBoolean;

public class Surround extends Module {
    public Surround() {
        super("Surround", KEY_UNBOUND, ModuleCategory.COMBAT, "hvh momento",
        new SettingBoolean("NoAirPlace", false),
        new SettingBoolean("Double", false),
        new SettingBoolean("SelfTrap", false),
        new SettingBoolean("SelfAnvil", false),
        new SettingBoolean("AntiCev", false),
        new SettingBoolean("CheckEntity", true),
        new SettingBoolean("OnlyGround", true),
        new SettingBoolean("Center", true),
        new SettingBoolean("DisableOnJump", true),
        new SettingBoolean("DisableOnYChange", true),
        new SettingBoolean("Rotations", true)
        );
    }
}
