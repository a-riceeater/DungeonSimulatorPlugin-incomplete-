package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class CustomDamage implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            if (!(e.getEntity() instanceof Player)) {
                Player player = (Player) e.getDamager();
                ItemMeta h = Objects.requireNonNull(player.getInventory().getHelmet()).getItemMeta();
                ItemMeta c = Objects.requireNonNull(player.getInventory().getChestplate()).getItemMeta();
                ItemMeta l = Objects.requireNonNull(player.getInventory().getLeggings()).getItemMeta();
                var damage = e.getDamage();
                // helmets
                if (h != null) {
                    if (h.equals(ItemManager.NECRONS_HELMET.getItemMeta())) {
                        e.setDamage(damage + 15);
                        player.sendMessage(ChatColor.RED + "Damage: " + e.getDamage());
                        if (e.getFinalDamage() + 15 < 0) {
                            if (e instanceof LivingEntity) {
                                ((LivingEntity) e).setHealth(0);
                                player.sendMessage(ChatColor.RED + "Damage: " + e.getDamage());
                            }
                        }
                    }
                }
                if (c != null) {
                    if (c.equals(ItemManager.NECRONS_CHESTPLATE.getItemMeta())) {
                        e.setDamage(damage + 15);
                        player.sendMessage(ChatColor.RED + "Damage: " + e.getDamage());
                        if (e.getFinalDamage() + 15 < 0) {
                            if (e instanceof LivingEntity) {
                                ((LivingEntity) e).setHealth(0);
                                player.sendMessage(ChatColor.RED + "Damage: " + e.getDamage());
                            }
                        }
                    }
                }
                if (l != null) {
                    if (l.equals(ItemManager.NECRONS_LGEGINGS.getItemMeta())) {
                        e.setDamage(damage + 15);
                        player.sendMessage(ChatColor.RED + "Damage: " + e.getDamage());
                        if (e.getFinalDamage() + 15 < 0) {
                            if (e instanceof LivingEntity) {
                                ((LivingEntity) e).setHealth(0);
                                player.sendMessage(ChatColor.RED + "Damage: " + e.getDamage());
                            }
                        }
                    }
                }
            }
        }
    }
}
