package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.guis.wheat;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class wheatevents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof wheat) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            } if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                if (player.getInventory().contains(Material.SUNFLOWER, 1)) {
                    player.getInventory().addItem(new ItemStack(Material.WHEAT));
                    player.getInventory().removeItem(new ItemStack(Material.SUNFLOWER));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 100);
                }
            } if (e.getCurrentItem().getType() == Material.GOLD_BLOCK) {
                if (player.getInventory().contains(Material.SUNFLOWER, 32)) {
                    player.getInventory().addItem(new ItemStack(Material.WHEAT, 64));
                    player.getInventory().removeItem(new ItemStack(Material.SUNFLOWER, 32));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 100);
                }
            }
        }
    }
}



