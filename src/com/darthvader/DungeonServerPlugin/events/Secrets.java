package com.darthvader.DungeonServerPlugin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Secrets implements Listener {
    @EventHandler
    public static void onBlockClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = e.getClickedBlock();
            if (block.getType() == Material.BARREL) {
                e.setCancelled(true);
                Player player = e.getPlayer();
                int secret = (int) (Math.random() * 1 + 1); // change to the amount of secrets dungeons has, guess of 5
                int item = (int) (Math.random() * 3 + 1); // 1/3 chance for secret to have an item
                if (secret == 1) { // wisdom secret
                    if (item == 1) {
                        player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                        int mana = (int) (Math.random() * 40);
                        int speed = (int) (Math.random() * 20);
                        Bukkit.getServer().broadcastMessage("§6§lDUNGEON BUFF! §r§f" + player.getDisplayName() + " found a §dBlessing of Wisdom V§f!");
                        Bukkit.getServer().broadcastMessage("§7Granted you " + ChatColor.AQUA + mana + " mana and " + ChatColor.WHITE + speed + " §7speed!");
                        player.closeInventory();
                        player.getInventory().setItem(7, new ItemStack(Material.LIGHT_BLUE_DYE, mana));
                        e.getClickedBlock().setType(Material.AIR);
                    }
                    else {
                        int mana = (int) (Math.random() * 40);
                        int speed = (int) (Math.random() * 20);
                        Bukkit.getServer().broadcastMessage("§6§lDUNGEON BUFF! §r§f" + player.getDisplayName() + " found a §dBlessing of Wisdom V§f!");
                        Bukkit.getServer().broadcastMessage("§7Granted you " + ChatColor.AQUA + mana + " mana and " + ChatColor.WHITE + speed + " §7speed!");
                        player.closeInventory();
                        player.getInventory().setItem(7, new ItemStack(Material.LIGHT_BLUE_DYE, mana));
                        e.getClickedBlock().setType(Material.AIR);
                    }
                }
                else if (secret == 2) { // stone secret
                    if (item == 1) {
                        int defense = (int) (Math.random() * 45);
                        player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                        Bukkit.getServer().broadcastMessage("§6§lDUNGEON BUFF! §r§f" + player.getDisplayName() + " found a §dBlessing of Stone I§f!");
                        Bukkit.getServer().broadcastMessage("§7Granted you " + ChatColor.AQUA + defense + " defense! §a(4:27)");
                        player.closeInventory();
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5340, 1));
                        e.getClickedBlock().setType(Material.AIR);
                    }
                    else {
                        int defense = (int) (Math.random() * 45);
                        Bukkit.getServer().broadcastMessage("§6§lDUNGEON BUFF! §r§f" + player.getDisplayName() + " found a §dBlessing of Stone I§f!");
                        Bukkit.getServer().broadcastMessage("§7Granted you " + ChatColor.AQUA + defense + " defense! §a(4:27)");
                        player.closeInventory();
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5340, 1));
                        e.getClickedBlock().setType(Material.AIR);
                    }
                }
            }
        }
    }
}
