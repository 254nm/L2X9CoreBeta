package org.l2x9.l2x9corebeta.events;

import org.bukkit.Material;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class BlockPlace extends BlockListener {
    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
        if (isChecked(event.getBlock().getType())) {
            event.setCancelled(true);
            event.getPlayer().sendRawMessage("[&bL2X9&r&3Core&r] &6That block is not allowed".replace("&", "§"));
            PlayerInventory inventory = event.getPlayer().getInventory();
            for (ItemStack itemStack : inventory.getContents()) {
                if (itemStack != null) {
                    if (isChecked(itemStack.getType())) {
                        inventory.remove(itemStack);
                    }
                }
            }
        }
    }
    private boolean isChecked(Material material) {
        switch (material) {
            case BEDROCK:
            case MOB_SPAWNER:
            case PORTAL:
                return true;
        }
        return false;
    }
}
