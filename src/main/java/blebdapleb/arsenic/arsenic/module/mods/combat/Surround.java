package blebdapleb.arsenic.arsenic.module.mods.combat;

import blebdapleb.arsenic.arsenic.event.events.EventTick;
import blebdapleb.arsenic.arsenic.eventbus.ArsenicSubscribe;
import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingBoolean;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingMode;
import blebdapleb.arsenic.arsenic.util.InventoryUtils;
import blebdapleb.arsenic.arsenic.util.player.PlayerUtils;
import blebdapleb.arsenic.arsenic.util.world.RotationUtils;
import blebdapleb.arsenic.arsenic.util.world.WorldUtils;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class Surround extends Module {
    public Surround() {
        super("Surround", KEY_UNBOUND, ModuleCategory.COMBAT, "New Surround");

    }

    int obiSlot;
    int oldSlot;

    @Override
    public void onEnable(boolean inWorld) {
            if (mc.player.isOnGround()) {
                PlayerUtils.centerPlayer();
                super.onEnable(inWorld);
            }
        }

    @ArsenicSubscribe
    public void onTick(EventTick eventTick) {
        if (mc.player == null) return;
        oldSlot = mc.player.getInventory().selectedSlot;
        obiSlot = -1;
        if (!mc.player.isOnGround()) {
            onDisable(mc.player.getWorld() != null ? true : false);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (mc.player.getInventory().getStack(i).getItem().equals(Items.OBSIDIAN)) {
                ArrayList<BlockPos> positions = new ArrayList<>();

                positions.add((mc.player.getBlockPos().north()));
                positions.add((mc.player.getBlockPos().south()));
                positions.add((mc.player.getBlockPos().west()));
                positions.add((mc.player.getBlockPos().east()));

                for (BlockPos pos : positions) {
                    WorldUtils.placeBlock(pos, i, 1, false, false, true);
                }
            }
        }
    }
}