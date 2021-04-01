package com.darthvader.DungeonServerPlugin.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CraftingEvents implements Listener {
    @EventHandler
    public void craftingdink(CraftItemEvent e) {
        Player player = (Player) e.getWhoClicked();
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_FLUTE, 5, 5);
    }
}
