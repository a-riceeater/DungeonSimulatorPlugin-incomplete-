package com.darthvader.DungeonServerPlugin.events;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class HyperionEvents implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.hyperion.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (!player.getAllowFlight()) {
                        if (player.getInventory().contains(Material.LIGHT_BLUE_DYE, 4)) {
                            player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 4));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 8));
                            Location loc = player.getLocation();
                            Vector dir = loc.getDirection();
                            dir.normalize();
                            dir.multiply(8);
                            loc.add(dir);
                            player.teleport(loc);
                            World world = player.getWorld();
                            for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5)) {
                                if (!(entity instanceof Mob)) continue;
                                var health = ((Mob) entity).getHealth();
                                if (entity.getType() == EntityType.WITHER) {
                                    int random = (int) (Math.random() * 15 + 1);
                                    ((Mob) entity).setHealth(health - random);
                                    player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                } else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                    player.sendMessage("§7Your implosion dealt " + ChatColor.RED + ((Mob) entity).getHealth() + "§7 damage");
                                    ((Mob) entity).setHealth(0);
                                } else {
                                    int random = (int) (Math.random() * 80 + 1);
                                    ((Mob) entity).setHealth(health - random);
                                    player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                }
                            }
                            player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation(), 5, 1, 1, 1);
                            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 100, 100);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have the mana for this!");
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void rightclick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.hyperion.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (!player.getAllowFlight()) {
                        if (player.getInventory().contains(Material.LIGHT_BLUE_DYE, 4)) {
                            player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 4));
                            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 8));
                            for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5)) {
                                if (!(entity instanceof Mob)) continue;
                                var health = ((Mob) entity).getHealth();
                                if (entity.getType() == EntityType.WITHER) {
                                    int random = (int) (Math.random() * 15 + 1);
                                    ((Mob) entity).setHealth(health - random);
                                    player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                } else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                    player.sendMessage("§7Your implosion dealt " + ChatColor.RED + ((Mob) entity).getHealth() + "§7 damage");
                                    ((Mob) entity).setHealth(0);
                                } else {
                                    int random = (int) (Math.random() * 80 + 1);
                                    ((Mob) entity).setHealth(health - random);
                                    player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                }
                            }
                            player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation(), 5, 1, 1, 1);
                            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 100, 100);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have the mana for this!");
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void rightClickFly(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.hyperion.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (player.getAllowFlight()) {
                            if (player.getInventory().contains(Material.LIGHT_BLUE_DYE, 4)) {
                                player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 4));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 8));
                                for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5)) {
                                    if (!(entity instanceof Mob)) continue;
                                    var health = ((Mob) entity).getHealth();
                                    if (entity.getType() == EntityType.WITHER) {
                                        int random = (int) (Math.random() * 15 + 1);
                                        ((Mob) entity).setHealth(health - random);
                                        player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                    } else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                        player.sendMessage("§7Your implosion dealt " + ChatColor.RED + ((Mob) entity).getHealth() + "§7 damage");
                                        ((Mob) entity).setHealth(0);
                                    } else {
                                        int random = (int) (Math.random() * 80 + 1);
                                        ((Mob) entity).setHealth(health - random);
                                        player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                    }
                                }
                                player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation(), 5, 1, 1, 1);
                                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 100, 100);
                        }
                        else {
                                player.sendMessage(ChatColor.RED + "You don't have the mana for this!");
                        }
                    }
                    else {
                        System.out.print("e");
                    }
                }
            }
        }
    }
    @EventHandler
    public void rightClickFlyBlock(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.hyperion.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (player.getAllowFlight()) {
                            if (player.getInventory().contains(Material.LIGHT_BLUE_DYE, 4)) {
                                player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 4));
                                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100, 8));
                                for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5)) {
                                    if (!(entity instanceof Mob)) continue;
                                    var health = ((Mob) entity).getHealth();
                                    if (entity.getType() == EntityType.WITHER) {
                                        int random = (int) (Math.random() * 15 + 1);
                                        ((Mob) entity).setHealth(health - random);
                                        player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                    } else if (entity.getType() == EntityType.WITHER_SKELETON) {
                                        player.sendMessage("§7Your implosion dealt " + ChatColor.RED + ((Mob) entity).getHealth() + "§7 damage");
                                        ((Mob) entity).setHealth(0);
                                    } else {
                                        int random = (int) (Math.random() * 80 + 1);
                                        ((Mob) entity).setHealth(health - random);
                                        player.sendMessage("§7Your implosion dealt " + ChatColor.RED + random + "§7 damage");
                                    }
                                }
                                player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, player.getLocation(), 5, 1, 1, 1);
                                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 100, 100);
                            }
                            else {
                                player.sendMessage(ChatColor.RED + "You don't have the mana for this!");
                            }
                    }
                    else {
                        System.out.print("e");
                    }
                }
            }
        }
    }
}