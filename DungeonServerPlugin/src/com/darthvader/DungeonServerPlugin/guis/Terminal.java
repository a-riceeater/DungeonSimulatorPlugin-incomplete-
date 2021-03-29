package com.darthvader.DungeonServerPlugin.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class Terminal implements InventoryHolder {

    private Inventory inv;

    public Terminal() {
        inv = Bukkit.createInventory(this, 36, "Terminal");
        init();
    }

    private void init() {
        ItemStack item;
            item = createItem("1", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(9, item);
            item = createItem("2", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(10, item);
            item = createItem("3", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(11, item);
            item = createItem("4", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(12, item);
            item = createItem("5", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(13, item);
            item = createItem("6", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(14, item);
            item = createItem("7", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(15, item);
            item = createItem("8", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(16, item);
            item = createItem("9", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(17, item);
            item = createItem("10", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(18, item);
            item = createItem("11", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(19, item);
            item = createItem("12", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(20, item);
            item = createItem("13", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(21, item);
            item = createItem("14", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(22, item);
            item = createItem("15", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(23, item);
            item = createItem("16", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(24, item);
            item = createItem("17", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(25, item);
            item = createItem("18", Material.RED_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(26, item);
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
