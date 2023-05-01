package blebdapleb.arsenic.arsenic.module.mods.render;

import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.util.ISimpleOption;

public class Fullbright extends Module {
    public Fullbright() {
        super("FullBright", KEY_UNBOUND, ModuleCategory.RENDER, "Night Vision");
    }

    @ArsenicSubscribe
    public void onTick(EventTick eventTick) {
        ((ISimpleOption<Double>)(Object)mc.options.getGamma()).setValueUnrestricted(100.0d);
    }
}
