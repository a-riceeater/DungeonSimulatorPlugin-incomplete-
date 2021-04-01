package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class withercloak implements Listener {
    private DungeonServerPlugin plugin;

    public withercloak() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.WITHER_CLOAK_SWORD.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (!plugin.withercloak.contains(player.getUniqueId())) {
                        plugin.withercloak.add(player.getUniqueId());
                        Location loc = player.getLocation();
                        Vector dir = loc.getDirection();
                        dir.normalize();
                        dir.multiply(2); //5 blocks a way
                        loc.add(dir);
                        Location loc2 = player.getLocation();
                        Vector dir2 = loc.getDirection();
                        dir2.normalize();
                        dir2.multiply(-2); //5 blocks a way
                        loc2.add(dir2);
                        Creeper creeper = (Creeper) player.getWorld().spawnEntity(loc, EntityType.CREEPER);
                        creeper.setInvulnerable(true);
                        creeper.setPowered(true);
                        creeper.setInvisible(true);
                        player.setInvulnerable(true);
                        Creeper creeper2 = (Creeper) player.getWorld().spawnEntity(loc2, EntityType.CREEPER);
                        creeper2.setInvulnerable(true);
                        creeper2.setPowered(true);
                        creeper2.setInvisible(true);
                        player.setInvulnerable(true);
                        Bukkit.getScheduler().scheduleSyncRepeatingTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), new Runnable() {
                            @Override
                            public void run() {
                                Location loc = player.getLocation();
                                Vector dir = loc.getDirection();
                                dir.normalize();
                                dir.multiply(2); //5 blocks a way
                                loc.add(dir);
                                creeper.teleport(loc);
                                Location loc2 = player.getLocation();
                                Vector dir2 = loc.getDirection();
                                dir2.normalize();
                                dir2.multiply(-2); //5 blocks a way
                                loc2.add(dir2);
                                creeper2.teleport(loc2);
                            }
                        }, 0L, 5L);
                    }
                    else {
                        plugin.withercloak.remove(player.getUniqueId());
                        player.setInvulnerable(false);
                        for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5)) {
                            if (!(entity instanceof Mob)) continue;
                            var health = ((Mob) entity).getHealth();
                            if (entity.getType() == EntityType.CREEPER) {
                                ((Mob) entity).setHealth(0);
                            }
                        }
                    }
                }
            }
        }
    }
}
