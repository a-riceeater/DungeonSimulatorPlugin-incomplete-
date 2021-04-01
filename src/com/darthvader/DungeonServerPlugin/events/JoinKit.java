package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinKit implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setMaxHealth(40);
        player.setHealth(40);
        if (!player.hasPlayedBefore()) {
            player.getInventory().setBoots(ItemManager.ROTTEN_BOOTS);
            player.getInventory().setLeggings(ItemManager.ROTTEN_LEGGINGS);
            player.getInventory().setChestplate(ItemManager.ROTTEN_CHESTPLATE);
            player.getInventory().setChestplate(ItemManager.ROTTEN_HELMET);
        }
    }
}
