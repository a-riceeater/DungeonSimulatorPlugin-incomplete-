package com.darthvader.DungeonServerPlugin.guis;

import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class items implements InventoryHolder {
    private Inventory inv;

    public items() {
        inv = Bukkit.createInventory(this, 54, "Item");
        init();
    }

    private void init() {
        inv.setItem(inv.firstEmpty(), ItemManager.ASPECT_OF_THE_END);
        inv.setItem(inv.firstEmpty(), ItemManager.ASPECT_OF_THE_DRAGONS);
        inv.setItem(inv.firstEmpty(), ItemManager.ASPECT_OF_THE_ELEPHANT);
        inv.setItem(inv.firstEmpty(), ItemManager.ASPECT_OF_THE_VADER);
        inv.setItem(inv.firstEmpty(), ItemManager.hyperion);
        inv.setItem(inv.firstEmpty(), ItemManager.EMERALD_BLADE);
        inv.setItem(inv.firstEmpty(), ItemManager.EDIBLE_MACE);
        inv.setItem(inv.firstEmpty(), ItemManager.ENCHANTED_DIAMOND_BLOCK);
        inv.setItem(inv.firstEmpty(), ItemManager.ENCHANTED_GOLD_BLOCK);
        inv.setItem(inv.firstEmpty(), ItemManager.ENCHANTED_GOLD_INGOT);
        inv.setItem(inv.firstEmpty(), ItemManager.ROTTEN_BOOTS);
        inv.setItem(inv.firstEmpty(), ItemManager.ROTTEN_CHESTPLATE);
        inv.setItem(inv.firstEmpty(), ItemManager.ROTTEN_HELMET);
        inv.setItem(inv.firstEmpty(), ItemManager.ROTTEN_LEGGINGS);
        inv.setItem(inv.firstEmpty(), ItemManager.ROUGE_SWORD);
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
