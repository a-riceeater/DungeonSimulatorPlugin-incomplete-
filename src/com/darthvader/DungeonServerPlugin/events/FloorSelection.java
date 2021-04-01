package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.guis.floors;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.concurrent.TimeUnit;

public class FloorSelection implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof floors) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.BLUE_CONCRETE) {
                Location location = new Location(player.getWorld(), -77, 104, 2);
                player.closeInventory();
                player.sendMessage(ChatColor.GOLD + "Joining Floor One Run....");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.GREEN + "Joining run in 5...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.GREEN + "Joining run in 4...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.GREEN + "Joining run in 3...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.GREEN + "Joining run in 2...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.GREEN + "Joining run in 1...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.AQUA + "Joining the run!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.teleport(location);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 5, 5);
                try {
                    TimeUnit.SECONDS.sleep(15);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.AQUA + "Run starting in 10!");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.AQUA + "Run starting in 5!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.AQUA + "Run starting in 4!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.AQUA + "Run starting in 3!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.AQUA + "Run starting in 2!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.AQUA + "Run starting in 1!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ev) {
                    ev.printStackTrace();
                }
                player.sendMessage(ChatColor.GOLD + "Run Started!");
            }
        }
    }
}
