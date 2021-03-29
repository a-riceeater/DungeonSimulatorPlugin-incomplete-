package com.darthvader.DungeonServerPlugin.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class diamond implements InventoryHolder {
    private Inventory inv;

    public diamond() {
        inv = Bukkit.createInventory(this, 36, "Mining > Enchanted Diamond Block");
        init();
    }

    private void init() {
        ItemStack item;
        for (int i = 0; i < 9; i++) {
            item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(" "));
            inv.setItem(i, item);
        }
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§9Buy only §6one", Material.GOLD_INGOT, Collections.singletonList("§720 Sunflower"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§7Enchanted Diamond Block", Material.DIAMOND_BLOCK, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§9Buy §24", Material.GOLD_BLOCK, Collections.singletonList("§72000 Sunflowers"));
        inv.setItem(inv.firstEmpty(), item);
        for (int i = 16; i < 36; i++) {
            item = createItem(" ", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(" "));
            inv.setItem(i, item);
        }
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
