package com.darthvader.DungeonServerPlugin.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;


public class bazaar implements InventoryHolder {

    private Inventory inv;

    public bazaar() {
        inv = Bukkit.createInventory(this, 45, "Bazaar");
        init();
    }

    private void init() {
        ItemStack item;
        //Farming
        item = createItem("§6Farming", Material.GOLDEN_HOE, Collections.singletonList("§7Farming Items - Click to view!"));
        inv.setItem(inv.firstEmpty(), item);
        for (int i = 1; i < 9; i++) {
            item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(i, item);
        }
        item = createItem("§6Mining", Material.DIAMOND_PICKAXE, Collections.singletonList("§7Mining Items - Click to view!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Wheat", Material.WHEAT, Collections.singletonList("§91 Sunflower"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Carrot", Material.CARROT, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Potato", Material.POTATO, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Pumpkin", Material.PUMPKIN, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Melon", Material.MELON, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Seeds", Material.WHEAT_SEEDS, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Combat", Material.IRON_SWORD, Collections.singletonList("§7Combat Items - Click to view!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Red Mushroom", Material.RED_MUSHROOM, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Brown Mushroom", Material.BROWN_MUSHROOM, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Cocoa Beans", Material.COCOA_BEANS, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Cactus", Material.CACTUS, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Sugar Cane", Material.SUGAR_CANE, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Feather", Material.FEATHER, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Fishing and wood", Material.FISHING_ROD, Collections.singletonList("§7Comming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Leather", Material.LEATHER, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Raw Porkchop", Material.PORKCHOP, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Raw Chicken", Material.CHICKEN, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Raw Mutton", Material.MUTTON, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Raw Rabbit", Material.RABBIT, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Nether Wart", Material.NETHER_WART, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Special Items I think?", Material.ENCHANTING_TABLE, Collections.singletonList("§7Comming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        for (int i = 37; i < 45; i++) {
            item = createItem(" ", Material.YELLOW_STAINED_GLASS_PANE, Collections.singletonList(""));
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
