package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class aspectoftheend implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.ASPECT_OF_THE_END.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (player.getInventory().contains(Material.LIGHT_BLUE_DYE, 2)) {
                        player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 2));
                        Location loc = player.getLocation();
                        Vector dir = loc.getDirection();
                        dir.normalize();
                        dir.multiply(8); //5 blocks a way
                        loc.add(dir);
                        if (loc.getBlock().getType() != null) {
                            player.teleport(loc);
                            player.sendMessage(ChatColor.AQUA + "Teleported 8 blocks ahead of you!");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "You don't have the mana for this!");
                    }
                }
            }
        }
    }
}
