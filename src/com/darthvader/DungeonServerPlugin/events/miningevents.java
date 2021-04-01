package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.guis.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class miningevents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof mining) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            } if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
                diamond gui = new diamond();
                player.openInventory(gui.getInventory());
            }
            else if (e.getCurrentItem().getType() == Material.GOLDEN_HOE) {
                bazaar gui = new bazaar();
                player.openInventory(gui.getInventory());
            }
            else if (e.getCurrentItem().getType() == Material.GOLD_BLOCK) {
                goldblock gui = new goldblock();
                player.openInventory(gui.getInventory());
            }
            else if (e.getCurrentItem().getType() == Material.DIAMOND_BLOCK) {
                diamond gui = new diamond();
                player.openInventory(gui.getInventory());
            }
        }
    }
}



