package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.guis.goldblock;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class goldblockevents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof goldblock) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            } if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                if (player.getInventory().contains(Material.SUNFLOWER, 10)) {
                    player.getInventory().addItem(ItemManager.ENCHANTED_GOLD_BLOCK);
                    player.getInventory().removeItem(new ItemStack(Material.SUNFLOWER, 10));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 100);
                }
            } if (e.getCurrentItem().getType() == Material.GOLD_BLOCK) {
                if (player.getInventory().contains(Material.SUNFLOWER, 1000)) {
                    player.getInventory().removeItem(new ItemStack(Material.SUNFLOWER, 1000));
                    for (int i = 1; i < 25; i++) {
                        player.getInventory().addItem(ItemManager.ENCHANTED_GOLD_BLOCK);
                    }
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 100);
                }
            }
        }
    }
}



