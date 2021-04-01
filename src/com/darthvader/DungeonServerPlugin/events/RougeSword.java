package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class RougeSword implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.ROUGE_SWORD.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.setWalkSpeed(player.getWalkSpeed() + 20);
                    player.sendMessage("§69Used speed boost! - 20 Mana");
                    player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 2));
                }
            }
        }
    }
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.ROUGE_SWORD.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.setWalkSpeed(player.getWalkSpeed() + 20);
                    player.sendMessage("§69Used speed boost! - 20 Mana");
                    player.getInventory().removeItem(new ItemStack(Material.LIGHT_BLUE_DYE, 2));
                }
            }
        }
    }
}
