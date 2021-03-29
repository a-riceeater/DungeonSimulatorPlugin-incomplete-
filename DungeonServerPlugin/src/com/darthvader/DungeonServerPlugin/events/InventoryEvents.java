package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT;


public class InventoryEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof selections) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                player.sendMessage(ChatColor.GREEN + "You have agreed that darthvader1925 is cool!");
                player.closeInventory();
                player.getInventory().addItem(ItemManager.heartoflove);
            }
            else if (e.getSlot() == 4) {
                player.sendMessage(ChatColor.AQUA + "Please select an option.");
                player.closeInventory();
                player.playSound(player.getLocation(), ENTITY_ENDERMAN_TELEPORT, 100, 100);

            }
            else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                player.sendMessage(ChatColor.RED + "You will die.");
                player.closeInventory();
                player.getWorld().createExplosion(player.getLocation(), 2.0f);
                player.getWorld().createExplosion(player.getLocation(), 2.0f);
            }
        }
    }
}


