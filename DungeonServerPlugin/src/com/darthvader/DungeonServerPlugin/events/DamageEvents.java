package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class DamageEvents implements Listener {
    private DungeonServerPlugin plugin;

    public DamageEvents() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }

    @EventHandler
    public void damageind(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player){
            Bukkit.getServer().getConsoleSender().sendMessage("A player took dmg!");
        }
        else {
            Player player = (Player) e.getDamager();
            ArmorStand stand = player.getWorld().spawn(e.getEntity().getLocation().subtract(0, 1, 0), ArmorStand.class, stands -> {
                stands.setVisible(false);
                stands.setGravity(false);
                stands.setCollidable(false);
                stands.setCustomName("§6⭐" + ChatColor.RED + e.getDamage() + "§6⭐");
                stands.setCustomNameVisible(true);
            });
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), new Runnable() {
                public void run() {
                   stand.remove();
                }
            }, 20L);
        }
    }
    @EventHandler
    public void knockback(EntityDamageByEntityEvent e) {
        if (e instanceof Player){
            Player player = (Player) e.getEntity();
            if (player.getInventory().contains(Material.SADDLE)) {
                e.setCancelled(true);
                if (player.getHealth() - e.getFinalDamage() < 0) {
                    player.setHealth(0);
                }
                else {
                    player.damage(e.getDamage());
                }
            }
        }
    }
    @EventHandler
    public void death(PlayerDeathEvent e) {
        Player player = e.getEntity();
        Location loc = e.getEntity().getLocation();
        var inventory = player.getInventory().getContents();
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), new Runnable() {
            public void run() {
                player.teleport(loc);
                player.setInvulnerable(true);
                player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 10000, 225));
                player.setInvisible(true);
                player.setAllowFlight(true);
                player.sendTitle(" §eYou Died!", "§aHopefully your teammates can revive you!!", 1, 20, 1);
                player.getInventory().clear();
            }
        }, 1L);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), new Runnable() {
            public void run() {
                player.getInventory().setContents(inventory);
                player.setInvulnerable(false);
                player.removePotionEffect(PotionEffectType.WEAKNESS);
                player.setInvisible(false);
                player.setAllowFlight(false);
            }
        }, 60L);
    }
    @EventHandler
    public void rune(EntityDeathEvent e) {
        if (!(e instanceof Player)) {
            e.getEntity().getWorld().spawnParticle(Particle.HEART, e.getEntity().getLocation(), 5);
        }
    }
    @EventHandler
    public void antidmg(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            if (plugin.withercloak.contains(e.getDamager().getUniqueId())) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void syphon(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            ArrayList<ItemStack> swords = new ArrayList<>();
            swords.add(ItemManager.hyperion);
            swords.add(ItemManager.ASPECT_OF_THE_END);
            swords.add(ItemManager.ASPECT_OF_THE_DRAGONS);
            swords.add(ItemManager.WITHER_CLOAK_SWORD);
            swords.add(ItemManager.EMERALD_BLADE);
            if (swords.contains(((Player) e.getDamager()).getInventory().getItemInMainHand())) {
                int random = (int) (Math.random() * 5 + 1);
                ((Player) e.getDamager()).setHealth(((Player) e.getDamager()).getHealth() + random);
            }
        }
    }
    @EventHandler
    public void antiwither(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof WitherSkeleton) {
            e.setCancelled(true);
            Player player = (Player) e.getEntity();
            if (player.getHealth() - e.getFinalDamage() < 0) {
                player.setHealth(0);
            }
            else {
                player.damage(e.getDamage());
            }
        }
    }
    @EventHandler
    public void zombiesword(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(ItemManager.ZOMBIE_SWORD.getItemMeta())) {
                    Player player = e.getPlayer();
                    if (player.getHealth() + 5 > 40) {
                        var health = 40 - player.getHealth();
                        player.sendMessage("§aYou healed yourself for " + ChatColor.GREEN + health + " §a health!");
                        player.setHealth(40 - player.getHealth());
                    }
                    player.setHealth(player.getHealth() + 5);
                    player.sendMessage("§aYou healed yourself for 5 health!");
                }
            }
        }
    }
}
