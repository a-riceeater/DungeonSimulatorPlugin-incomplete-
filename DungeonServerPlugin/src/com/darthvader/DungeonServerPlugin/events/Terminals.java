package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import com.darthvader.DungeonServerPlugin.guis.Terminal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Terminals implements Listener {
    private DungeonServerPlugin plugin;

    public Terminals() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) {
            return;
        }
        if (e.getClickedInventory().getHolder() instanceof Terminal) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                var slot = e.getSlot();
                e.getCurrentItem().setType(Material.GREEN_STAINED_GLASS_PANE);
                slot++;
                if (slot == 27) {
                    Bukkit.getServer().broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " activated a terminal!");
                    player.closeInventory();
                }
            }
        }
    }
    @EventHandler
    public void onBlockClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType() == Material.COMMAND_BLOCK) {
                Terminal gui = new Terminal();
                player.openInventory(gui.getInventory());
            }
        }
    }
}
