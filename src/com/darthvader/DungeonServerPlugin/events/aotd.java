package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class aotd implements Listener {

    private ArrayList<String> cooldown = new ArrayList<String>();

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.ASPECT_OF_THE_DRAGONS.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.sendMessage(ChatColor.AQUA + "Used dragon rage!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 100, 100);
                }
            }
        }
    }
}
