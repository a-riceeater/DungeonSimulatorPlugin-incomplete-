package com.darthvader.DungeonServerPlugin.guis;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class floors implements InventoryHolder {
    private Inventory inv;

    public floors() {
        inv = Bukkit.createInventory(this, 27, "Catacombs Gate");
        init();
    }

    private void init() {
        ItemStack item;
        for (int i = 1; i < 9; i++) {
            item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(i, item);
        }
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        inv.setItem(inv.firstEmpty(), ItemManager.FLOOR_ONE);
    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
