package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.guis.bazaar;
import com.darthvader.DungeonServerPlugin.guis.mining;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class bazaarevents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof bazaar) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE) {
                mining gui = new mining();
                player.openInventory(gui.getInventory());
            }
        }
    }
}


