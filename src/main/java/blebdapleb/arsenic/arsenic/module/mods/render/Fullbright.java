package blebdapleb.arsenic.arsenic.module.mods.render;

import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;

public class Fullbright extends Module {
    public Fullbright() {
        super("FullBright", KEY_UNBOUND, ModuleCategory.RENDER, "Night Vision");
    }

    @ArsenicSubscribe
    public void onEnable() {

    }
}
