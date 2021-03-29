package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.util.Vector;

public class WorldGuard implements Listener {
    private DungeonServerPlugin plugin;

    public WorldGuard() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }
    // Anti Fall Dmg
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                e.setCancelled(true);
            }
        }
    }
    // Anti Block Break
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (!e.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }
    // Anti Block Place
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.TNT) {
            Bukkit.getServer().getConsoleSender().sendMessage(e.getPlayer().getDisplayName() + " placed superboom tnt!");
        }
        else {
            if (!e.getPlayer().isOp()) {
                e.setCancelled(true);
            }
        }
    }
    // Necron Lava Launch
    @EventHandler
    public void lavadmg(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getCause() == EntityDamageEvent.DamageCause.LAVA) {
                Player player = (Player) e.getEntity();
                if (player.getHealth() - e.getFinalDamage() < 0) {
                    player.setHealth(0);
                    player.sendMessage("§7Necron's True Lava hit you for " + ChatColor.RED + e.getDamage() + 10.0 + " §7true damage");
                }
                else {
                    player.setHealth(player.getHealth() - 10);
                    player.setVelocity(new Vector(0, 20, 0));
                    player.sendMessage("§7Necron's True Lava hit you for " + ChatColor.RED + e.getDamage() + 10.0 + " §7true damage");
                }
            }
        }
    }
    // Chat Cool-down
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player player = e.getPlayer();
        if (plugin.chatcooldown.contains(player.getUniqueId())) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.GOLD + "---------------------------------------------");
            player.sendMessage(ChatColor.RED + "You can only chat once every 3 seconds! Ranked users bypass");
            player.sendMessage(ChatColor.RED + "this restriction!");
            player.sendMessage(ChatColor.GOLD + "---------------------------------------------");
        }
        else {
            plugin.chatcooldown.add(player.getUniqueId());
            Bukkit.getScheduler().scheduleSyncDelayedTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), new Runnable() {
                @Override
                public void run() {
                    plugin.chatcooldown.remove(player.getUniqueId());
                }
            }, 60L);
        }
    }
    @EventHandler
    public void explodeblock(BlockExplodeEvent e) {
        e.setCancelled(true);
    }
}
