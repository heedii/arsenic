package blebdapleb.arsenic.arsenic.module.mods.render;

import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Fullbright extends Module {

    public Fullbright() {
        super("FullBright", KEY_UNBOUND, ModuleCategory.RENDER, "it gives you NightVision Effect. lol");
    }

    @ArsenicSubscribe
    public void onTick(EventTick eventTick) {
        mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 5200, 1));
    }

    @Override
    public void onDisable(boolean inWorld) {
        mc.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        super.onDisable(inWorld);
    }
}
