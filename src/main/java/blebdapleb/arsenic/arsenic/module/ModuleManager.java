package blebdapleb.arsenic.arsenic.module;

import blebdapleb.arsenic.arsenic.module.mods.misc.AutoRespawn;
import blebdapleb.arsenic.arsenic.module.mods.misc.SelfDestruct;
import blebdapleb.arsenic.arsenic.module.mods.movement.*;
import blebdapleb.arsenic.arsenic.module.mods.client.ClickGui;
import blebdapleb.arsenic.arsenic.module.mods.combat.*;
import blebdapleb.arsenic.arsenic.module.mods.client.Hud;
import blebdapleb.arsenic.arsenic.module.mods.render.ESP;
import blebdapleb.arsenic.arsenic.module.mods.render.Fullbright;
import blebdapleb.arsenic.arsenic.module.mods.render.Tracers;
import blebdapleb.arsenic.arsenic.util.collections.NameableStorage;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {

    private static final NameableStorage<Module> MODULES = new NameableStorage<>(Module::getName);

    public ModuleManager() { init(); }

    public void init() {
        // MOVEMENT
        MODULES.add(new Jesus());
        MODULES.add(new JetPack());
        MODULES.add(new NoFall());
        MODULES.add(new Sprint());
        MODULES.add(new Flight());
        //MODULES.add(new DoubleJump());

        // COMBAT
        MODULES.add(new Hitbox());
        MODULES.add(new Aimbot());
        MODULES.add(new Reach());
        MODULES.add(new LegitCrystal());
        MODULES.add(new AnchorMacro());
        MODULES.add(new AutoTotem());
        MODULES.add(new Criticals());
        MODULES.add(new AutoPot());
        MODULES.add(new BowBot());
        MODULES.add(new Surround());

        // RENDER
        MODULES.add(new ESP());
        MODULES.add(new Tracers());
        MODULES.add(new Fullbright());

        // MISC
        MODULES.add(new SelfDestruct());
        MODULES.add(new AutoRespawn());

        // CLIENT
        MODULES.add(new ClickGui());
        MODULES.add(new Hud());

    }

    public static Iterable<Module> getModules() {
        return MODULES.values();
    }

    public static List<Module> getEnabledModules()
    {
        List<Module> enabled = new ArrayList<>();
        for (Module m : MODULES.values())
        {
            if (m.isEnabled()) enabled.add(m);
        }
        return enabled;
    }

    public static Module getModule(String name) {
        return MODULES.get(name);
    }

    public static <M extends Module> M getModule(Class<M> class_) {
        return MODULES.get(class_);
    }

    public static List<Module> getModulesInCat(ModuleCategory cat) {
        return MODULES.stream().filter(m -> m.getCategory().equals(cat)).collect(Collectors.toList());
    }

    public static void handleKey(int key) {
        if (!InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_F3)) {
            for (Module m: getModules()) {
                if (m.getKey() == key) {
                    m.toggle();
                }
            }
        }
    }
}
