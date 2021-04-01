package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class BoneMerang implements Listener {
    @EventHandler
    public void RightClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getItem().getItemMeta().equals(ItemManager.BONEMERANG.getItemMeta())) {
                Player player = e.getPlayer();
                var slot = player.getInventory().getHeldItemSlot();
                ArmorStand stand = player.getWorld().spawn(player.getLocation().subtract(0, 1, 0), ArmorStand.class, stands -> {
                    stands.setVisible(false);
                    stands.getEquipment().setItemInMainHand(new ItemStack(Material.BONE));
                    stands.setGravity(false);
                    stands.setCollidable(false);
                });
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(1);
                    loc.add(dir);
                    stand.teleport(loc);
                    player.getInventory().removeItem(new ItemStack(Material.GHAST_TEAR));
                    player.getInventory().setItem(slot, ItemManager.BONEMERANG_COOLDOWN);
                }, 0L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(2);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 2L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(3);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 4L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(4);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 6L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(5);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 8L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(6);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 10L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(7);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 12L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(8);
                    loc.add(dir);
                    stand.teleport(loc);
                    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.DEATH_BOW.getItemMeta())) {
                        for (Entity entity : player.getWorld().getNearbyEntities(stand.getLocation(), 2, 2, 2)) {
                            if (!(entity instanceof Mob)) continue;
                            var health = ((Mob) entity).getHealth();
                            if (entity.getType() == EntityType.WITHER) {
                                int random = (int) (Math.random() * 15 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                            else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                ((Mob) entity).setHealth(0);
                            }
                            else {
                                int random = (int) (Math.random() * 60 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                        }
                    }
                    else {
                        for (Entity entity : player.getWorld().getNearbyEntities(stand.getLocation(), 2, 2, 2)) {
                            if (!(entity instanceof Mob)) continue;
                            var health = ((Mob) entity).getHealth();
                            if (entity.getType() == EntityType.WITHER) {
                                int random = (int) (Math.random() * 15 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                            else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                ((Mob) entity).setHealth(0);
                            }
                            else {
                                int random = (int) (Math.random() * 60 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                        }
                    }
                }, 14L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(7);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 16L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(6);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 18L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(5);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 20L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(4);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 22L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(3);
                    loc.add(dir);
                    stand.teleport(loc);
                }, 24L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(2);
                    loc.add(dir);
                    stand.teleport(loc);
                    if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(ItemManager.DEATH_BOW.getItemMeta())) {
                        for (Entity entity : player.getWorld().getNearbyEntities(stand.getLocation(), 2, 2, 2)) {
                            if (!(entity instanceof Mob)) continue;
                            var health = ((Mob) entity).getHealth();
                            if (entity.getType() == EntityType.WITHER) {
                                int random = (int) (Math.random() * 15 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                            else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                ((Mob) entity).setHealth(0);
                            }
                            else {
                                int random = (int) (Math.random() * 60 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                        }
                    }
                    else {
                        for (Entity entity : player.getWorld().getNearbyEntities(stand.getLocation(), 2, 2, 2)) {
                            if (!(entity instanceof Mob)) continue;
                            var health = ((Mob) entity).getHealth();
                            if (entity.getType() == EntityType.WITHER) {
                                int random = (int) (Math.random() * 15 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                            else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                ((Mob) entity).setHealth(0);
                            }
                            else {
                                int random = (int) (Math.random() * 60 + 1);
                                ((Mob) entity).setHealth(health - random);
                            }
                        }
                    }
                }, 26L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    dir.normalize();
                    dir.multiply(1);
                    loc.add(dir);
                    stand.teleport(loc);
                    stand.remove();
                    player.getInventory().removeItem(new ItemStack(Material.GHAST_TEAR));
                    player.getInventory().setItem(slot, ItemManager.BONEMERANG);
                }, 28L);
            }
        }
    }
    @EventHandler
    public void boneplating(EntityDamageEvent e) {
        if (e instanceof Player) {
            Player player = (Player) e.getEntity();
            if (player.getInventory().contains(ItemManager.BONEMERANG_COOLDOWN)) {
                int dmg = (int) (Math.random() * 20 + 1);
                player.setHealth(player.getHealth() + dmg);
                player.sendMessage("§eYour bone plating reduced the damage you took by " + ChatColor.RED + dmg);
            }
        }
    }
}