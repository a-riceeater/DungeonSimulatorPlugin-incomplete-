package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class ediblemace implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.EDIBLE_MACE.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (player.getInventory().contains(Material.LIGHT_BLUE_DYE, 25)) {
                        player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 25));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20, 25));
                        player.playSound(player.getLocation(), Sound.ENTITY_WOLF_HOWL, 100, 100);
                        player.sendMessage(ChatColor.AQUA + "-25 Mana ME SMASH HERO");
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "You do not have the mana for this!");
                    }
                }
            }
        }
    }
}