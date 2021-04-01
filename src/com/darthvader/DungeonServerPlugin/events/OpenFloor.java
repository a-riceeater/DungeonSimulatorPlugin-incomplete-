package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.guis.floors;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenFloor implements Listener {
    @EventHandler
    public static void onBlockClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() == Material.OAK_WALL_SIGN) {
                Player player = event.getPlayer();
                floors gui = new floors();
                player.openInventory(gui.getInventory());
            }
        }
    }
}
