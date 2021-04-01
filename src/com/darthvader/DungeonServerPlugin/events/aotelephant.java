package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class aotelephant implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.ASPECT_OF_THE_ELEPHANT.getItemMeta())) {
                    Player player = event.getPlayer();
                   Location locr = player.getLocation();
                    double locy = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getY();
                    for(double i = locy; i > -2; i--){
                        Block b = locr.getBlock();
                        b.setType(Material.AIR);
                        locr.setY(locr.getY()-1);
                    }
                }
            }
        }
    }
}
