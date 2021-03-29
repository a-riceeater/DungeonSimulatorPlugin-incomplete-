package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class aoteblock implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.ASPECT_OF_THE_END.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                }
            }
        }
    }
}
