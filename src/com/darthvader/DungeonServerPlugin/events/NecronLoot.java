package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;

public class NecronLoot implements Listener {
    @EventHandler
    public void onKill(EntityDeathEvent e) {
        Entity entity = e.getEntity();
        Entity killer = e.getEntity().getKiller();

        if (killer instanceof Player) {
            if (entity.getType() == EntityType.WITHER) {
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Bukkit.getServer().broadcastMessage("§4[BOSS] Necron §cI CAN'T BELIEVE YOU JUST DID THAT!");
                }, 20L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Bukkit.getServer().broadcastMessage("§4[BOSS] Necron §cI understand your words now, my master.");
                }, 40L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Bukkit.getServer().broadcastMessage("§4[BOOS] Necron §cThe Catacombs, are no more.");
                }, 60L);
                Player player = e.getEntity().getKiller();
                Location location = new Location(player.getWorld(), -81, 103, -19);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.teleport(location);
                    }
                }, 80L);
                int brandom = (int) (Math.random() * 20 + 1);
                if (brandom == 4) {
                    Location bedrock = new Location(player.getWorld(), -85 ,103, -20, 0, -90);
                    bedrock.getBlock().setType(Material.CHEST);
                    Block b = bedrock.getBlock();
                    Chest bc = (Chest) b.getState();
                    Inventory chestInv = bc.getInventory();
                    chestInv.setItem(13, ItemManager.NECRONS_HANDLE);
                }
                else if (brandom == 5){
                    Location bedrock = new Location(player.getWorld(), -85 ,103, -20, 0, -90);
                    bedrock.getBlock().setType(Material.CHEST);
                    Block b = bedrock.getBlock();
                    Chest bc = (Chest) b.getState();
                    Inventory chestInv = bc.getInventory();
                    chestInv.setItem(13, ItemManager.SHADOW_WARP);
                }
                else if (brandom == 6){
                    Location bedrock = new Location(player.getWorld(), -85 ,103, -20, 0, -90);
                    bedrock.getBlock().setType(Material.CHEST);
                    Block b = bedrock.getBlock();
                    Chest bc = (Chest) b.getState();
                    Inventory chestInv = bc.getInventory();
                    chestInv.setItem(13, ItemManager.IMPLOSION);
                }
                else if (brandom == 7){
                    Location bedrock = new Location(player.getWorld(), -85 ,103, -20, 0, -90);
                    bedrock.getBlock().setType(Material.CHEST);
                    Block b = bedrock.getBlock();
                    Chest bc = (Chest) b.getState();
                    Inventory chestInv = bc.getInventory();
                    chestInv.setItem(13, ItemManager.WITHER_SHIELD);
                }
                else if (brandom == 8){
                    Location bedrock = new Location(player.getWorld(), -85 ,103, -20, 0, -90);
                    bedrock.getBlock().setType(Material.CHEST);
                    Block b = bedrock.getBlock();
                    Chest bc = (Chest) b.getState();
                    Inventory chestInv = bc.getInventory();
                    chestInv.setItem(13, ItemManager.WITHER_CLOAK_SWORD);
                }
                else {
                    Location bedrock = new Location(player.getWorld(), -85 ,103, -20, 0, -90);
                    bedrock.getBlock().setType(Material.CHEST);
                    Block b = bedrock.getBlock();
                    Chest bc = (Chest) b.getState();
                    Inventory chestInv = bc.getInventory();
                    chestInv.setItem(12, ItemManager.REJUVIANTE_THREE);
                    chestInv.setItem(13, ItemManager.WISDOM_THREE);
                }
            }
        }
    }
}
