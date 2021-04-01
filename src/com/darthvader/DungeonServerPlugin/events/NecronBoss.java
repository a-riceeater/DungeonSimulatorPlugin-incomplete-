package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class NecronBoss implements Listener {

    private DungeonServerPlugin plugin;

    public NecronBoss() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location loc = new Location(player.getWorld(), -141, 102, 23);
        if (player.getLocation().distanceSquared(loc) < 3) {
            Location phase1 = new Location(player.getWorld(), -73, 102, 26, 90, 1);
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                p.teleport(phase1);
            }
            Location crystal1 = new Location(player.getWorld(), -80, 108, 15);
            EnderCrystal crystal = (EnderCrystal) player.getWorld().spawnEntity(crystal1, EntityType.ENDER_CRYSTAL);
            crystal.setCustomName("§bENERGY CRYSTAL §eCLICK HERE");
            crystal.setCustomNameVisible(true);
            new BukkitRunnable() {
                private int i = 0;

                @Override
                public void run() {
                    if (i >= 40) {
                        cancel();
                    }
                    ++i;
                    Location skeletons = new Location(player.getWorld(), -87, 105, 25);
                    WitherSkeleton witherskele = (WitherSkeleton) player.getWorld().spawnEntity(skeletons, EntityType.WITHER_SKELETON);
                    witherskele.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 18000, 2));
                    witherskele.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 18000, 1));
                    witherskele.setCustomName("§cWither Miner");
                    witherskele.setMaxHealth(40);
                    witherskele.setHealth(40);
                }
            }.runTaskTimer(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), 100L, 5L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                Location witherloc = new Location(player.getWorld(), -87, 115, 25);
                Wither wither = (Wither) player.getWorld().spawnEntity(witherloc, EntityType.WITHER);
                wither.setMaxHealth(2048);
                wither.setHealth(2048);
                wither.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1734000, 2));
                wither.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1734000, 2));
                wither.setCustomName("§cNecron");
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc12 = new Location(player.getWorld(), -90, 102, 39);
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "[BOSS] §cFINE! LETS GO SOMEWHERE ELSE!");
                    loc12.getBlock().setType(Material.REDSTONE_BLOCK);
                    Location tp = new Location(player.getWorld(), -87, 96, 26);
                    player.teleport(tp);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 600, 2));
                    wither.teleport(player);
                }, 850L);
                Bukkit.getScheduler().scheduleSyncRepeatingTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> {
                    Location loc1 = new Location(player.getWorld(), -81, 70, 20);
                    if (wither.getLocation().distanceSquared(loc1) < 5) {
                        new BukkitRunnable() {
                            private int i = 0;

                            @Override
                            public void run() {
                                if (i >= 40) {
                                    cancel();
                                }
                                ++i;
                                wither.teleport(wither.getLocation());
                            }
                        }.runTaskTimer(plugin, 0L, 5L);
                        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                            p.sendTitle(" §cNECRON IS ENRAGED!", "", 1, 60, 1);
                        }
                    }
                }, 0L, 5L);
            }, 650L);
        }
    }
    @EventHandler
    public void crystalbreak(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location loc = new Location(player.getWorld(), -81, 108, 15);
        if (player.getLocation().distanceSquared(loc) < 3) {
            if (!plugin.crystal) {
                plugin.crystal = true;
                for (Entity entity : player.getWorld().getNearbyEntities(player.getLocation(), 2, 2, 2)) {
                    if (!(entity instanceof Mob)) continue;
                    if (entity.getType() == EntityType.ENDER_CRYSTAL) {
                        ((Mob) entity).setHealth(0);
                    }
                }
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.sendTitle("§a1/2 Energy Crystals are now active!", "", 1, 40, 1);
                }
                player.getInventory().addItem(new ItemStack(Material.NETHER_STAR));
            }
        }
    }
    @EventHandler
    public void crystalspawn(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location loc = new Location(player.getWorld(), -82, 104, 35);
        if (player.getLocation().distanceSquared(loc) < 3) {
            if (player.getInventory().contains(Material.NETHER_STAR)) {
                Location beacon = new Location(player.getWorld(), -105, 105, 26);
                beacon.getBlock().setType(Material.RED_STAINED_GLASS);
                player.getInventory().removeItem(new ItemStack(Material.NETHER_STAR));
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.sendTitle("§a2/2 Energy Crystals are now active!", "", 1, 40, 1);
                }
            }
        }
    }
}
