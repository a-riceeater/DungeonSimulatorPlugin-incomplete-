package com.darthvader.DungeonServerPlugin.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class mining implements InventoryHolder {

    private Inventory inv;

    public mining() {
        inv = Bukkit.createInventory(this, 45, "Bazaar");
        init();
    }
    private void init() {
        ItemStack item;
        item = createItem("§6Farming", Material.GOLDEN_HOE, Collections.singletonList("§7Farming Items - Click to view!"));
        inv.setItem(inv.firstEmpty(), item);
        for (int i = 1; i < 9; i++) {
            item = createItem(" ", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(i, item);
        }
        item = createItem("§6Mining", Material.DIAMOND_PICKAXE, Collections.singletonList("§7Mining Items - Click to view!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Cobblestone", Material.COBBLESTONE, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Coal", Material.COAL, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Enchanted Iron Block", Material.IRON_BLOCK, Collections.singletonList("§9100 Sunflowers"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Enchanted Gold Ingot", Material.GOLD_INGOT, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Enchanted Gold Block", Material.GOLD_BLOCK, Collections.singletonList("§c10 Sunflowers"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Enchanted Diamond Block", Material.DIAMOND_BLOCK, Collections.singletonList("§c20 Sunflowers"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Lapis Lazuli", Material.LAPIS_LAZULI, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Combat", Material.IRON_SWORD, Collections.singletonList("§7Combat Items - Click to view!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Enchanted Emerald Block", Material.EMERALD, Collections.singletonList("§c32 Sunflowers"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Redstone", Material.REDSTONE, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Quartz", Material.QUARTZ, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Obsidian", Material.OBSIDIAN, Collections.singletonList("§c3 Sunflowers"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Glowstone", Material.GLOWSTONE_DUST, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Gravel", Material.GRAVEL, Collections.singletonList("§cComming Soon"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Flint", Material.FLINT, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Fishing and Wood", Material.FISHING_ROD, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem(" ", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Collections.singletonList(" "));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Ice", Material.ICE, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
        item = createItem("§6Netherrack", Material.NETHERRACK, Collections.singletonList("§cComming Soon!"));
        inv.setItem(inv.firstEmpty(), item);
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
