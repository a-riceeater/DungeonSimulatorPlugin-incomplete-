package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ScoreboardObjects implements Listener {
    private DungeonServerPlugin plugin;

    public ScoreboardObjects() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        plugin.maxmana.put(e.getPlayer().getUniqueId(), 100);
        plugin.coins.put(e.getPlayer().getUniqueId(), 0);
        plugin.mana.put(e.getPlayer().getUniqueId(), plugin.maxmana.get(e.getPlayer().getUniqueId()));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), new Runnable() {
            @Override
            public void run() {
                Player player = e.getPlayer();
                if (!(plugin.mana.get(player.getUniqueId()).equals(plugin.maxmana.get(player.getUniqueId())))) {
                    plugin.mana.put(player.getUniqueId(), plugin.mana.get(player.getUniqueId()) + 5);
                }
                Date now = new Date();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                final Scoreboard board = manager.getNewScoreboard();
                final Objective objective = board.registerNewObjective("test", "dummy");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(ChatColor.YELLOW + "§lDUNGEON SIMULATOR");
                Score title = objective.getScore(ChatColor.GRAY + format.format(now));
                title.setScore(3);
                Score mana = objective.getScore("§9Mana: " + ChatColor.BLUE + plugin.mana.get(player.getUniqueId()) + "§9/" + plugin.mana.get(player.getUniqueId()));
                mana.setScore(2);
                Score placeholder1 = objective.getScore("");
                placeholder1.setScore(1);
                Score coins = objective.getScore("§6Coins: " + ChatColor.GOLD + plugin.coins.get(player.getUniqueId()));
                coins.setScore(0);
                player.setScoreboard(board);
            }
        }, 0L, 20L); //0 Tick initial delay, 20 Tick (1 Second) between repeats
    }
    @EventHandler
    public void onArmor(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack h = player.getInventory().getHelmet();
        ItemStack c = player.getInventory().getChestplate();
        ItemStack l = player.getInventory().getLeggings();
        ItemStack b = player.getInventory().getBoots();
        if (e.getSlotType() == InventoryType.SlotType.ARMOR) {
            if (e.getCurrentItem().getItemMeta().equals(ItemManager.STORM_HELMET.getItemMeta())) {
                plugin.maxmana.put(player.getUniqueId(), plugin.maxmana.get(player.getUniqueId()) + 400);
            }
        }
    }
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if (!(e instanceof Player)) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.SUNFLOWER));
        }
    }
    @EventHandler
    public void sunflowerPickup(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        ItemStack item = new ItemStack(Material.SUNFLOWER);
        if (e.getItem().getItemStack().equals(item)) {
            player.getInventory().removeItem(new ItemStack(Material.SUNFLOWER, 1));
            plugin.coins.put(player.getUniqueId(), plugin.coins.get(player.getUniqueId()) + 15);
        }
    }
}