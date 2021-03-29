package com.darthvader.DungeonServerPlugin.guis;


import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class ItemSelections implements InventoryHolder {

    private Inventory inv;

    public ItemSelections() {
        inv = Bukkit.createInventory(this, 54, "Grub Hub Items"); //54 is max size.
    }

    private void init() {
        inv.addItem(ItemManager.hyperion);
        inv.addItem(ItemManager.heartoflove);
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
