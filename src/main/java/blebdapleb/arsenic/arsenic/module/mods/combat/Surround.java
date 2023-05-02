package blebdapleb.arsenic.arsenic.module.mods.combat;

import blebdapleb.arsenic.arsenic.module.Module;
import blebdapleb.arsenic.arsenic.module.ModuleCategory;
import blebdapleb.arsenic.arsenic.module.setting.settings.SettingMode;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class Surround extends Module {
    public Surround() {
        super("Surround", KEY_UNBOUND, ModuleCategory.COMBAT, "hvh momento");
                new SettingMode("Mode", "Obsidian", "Obsidian", "Bedrock", "NetheriteBlock"
                        );
    }

    int obiSlot;
    int oldSlot;

    @Override
    public void onTick() {
        if (mc.player == null) return;
        oldSlot = mc.player.getInventory().selectedSlot;
        obiSlot = -1;
        if (!mc.player.isOnGround())
        {onDisable(mc.player.getWorld() !=null ? true : false);
            return;}
        ArrayList<BlockPos> positions = new ArrayList<>();
        positions.add((mc.player.getBlockPos().north()));
        positions.add((mc.player.getBlockPos().south()));
        positions.add((mc.player.getBlockPos().west()));
        positions.add((mc.player.getBlockPos().east()));
        for (int i = 0; i < 9; i++) {
                if (mc.player.getInventory().getStack(i).getItem().equals(Items.OBSIDIAN)) {
                    obiSlot = i;
                    break;
                } else {
                    if (mc.player.getInventory().getStack(i).getItem().equals(Items.BEDROCK)) {
                        obiSlot = i;
                        break;
                    }
                } else {
                    if(mc.player.getInventory().getStack(i).getItem().equals(Items.NETHERITE_BLOCK)) {

                    }
            }
        }

    }
}
