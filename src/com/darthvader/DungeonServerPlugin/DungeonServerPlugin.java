package com.darthvader.DungeonServerPlugin;

import com.darthvader.DungeonServerPlugin.commands.commands;
import com.darthvader.DungeonServerPlugin.events.*;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DungeonServerPlugin extends JavaPlugin {
    public ArrayList<UUID> withercloak = new ArrayList<>();
    public ArrayList<UUID> chatcooldown = new ArrayList<>();
    public ArrayList<UUID> fly = new ArrayList<>();
    public Boolean crystal;
    public Map<UUID, Integer> mana = new HashMap<>();
    public Map<UUID, Integer> maxmana = new HashMap<>();
    public Map<UUID, Integer> coins = new HashMap<>();
    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[DungeonServerPlugin]: Plugin has been enabled!");
        ItemManager.init();
        getCommand("gmc").setExecutor(new commands());
        getCommand("gms").setExecutor(new commands());
        getCommand("gmsp").setExecutor(new commands());
        getCommand("givehyperion").setExecutor(new commands());
        getCommand("items").setExecutor(new commands());
        getCommand("shadowassasin").setExecutor(new commands());
        getCommand("bz").setExecutor(new commands());
        getCommand("rougesword").setExecutor(new commands());
        getCommand("aote").setExecutor(new commands());
        getCommand("aotd").setExecutor(new commands());
        getCommand("aotv").setExecutor(new commands());
        getCommand("heal").setExecutor(new commands());
        getCommand("aotelephant").setExecutor(new commands());
        getCommand("withercloak").setExecutor(new commands());
        getCommand("emeraldblade").setExecutor(new commands());
        getCommand("brodcast").setExecutor(new commands());
        getCommand("mace").setExecutor(new commands());
        getCommand("nick").setExecutor(new commands());
        getCommand("nickreset").setExecutor(new commands());
        getCommand("handle").setExecutor(new commands());
        getCommand("bone").setExecutor(new commands());
        getCommand("necron").setExecutor(new commands());
        getCommand("ban").setExecutor(new commands());
        getCommand("unban").setExecutor(new commands());
        getCommand("deathbow").setExecutor(new commands());
        getCommand("golem").setExecutor(new commands());
        getCommand("fly").setExecutor(new commands());
        getCommand("la").setExecutor(new commands());
        getCommand("zombiesword").setExecutor(new commands());
        getCommand("storm").setExecutor(new commands());
        getCommand("necronarmor").setExecutor(new commands());
        getServer().getPluginManager().registerEvents((Listener) new HyperionEvents(), this);
        getServer().getPluginManager().registerEvents((Listener) new JoinKit(), this);
        getServer().getPluginManager().registerEvents((Listener) new bazaarevents(), this);
        getServer().getPluginManager().registerEvents((Listener) new wheatevents(), this);
        getServer().getPluginManager().registerEvents((Listener) new miningevents(), this);
        getServer().getPluginManager().registerEvents((Listener) new RougeSword(), this);
        getServer().getPluginManager().registerEvents((Listener) new goldblockevents(), this);
        getServer().getPluginManager().registerEvents((Listener) new diamondevents(), this);
        getServer().getPluginManager().registerEvents((Listener) new aspectoftheend(), this);
        getServer().getPluginManager().registerEvents((Listener) new aotd(), this);
        getServer().getPluginManager().registerEvents((Listener) new aotdblock(), this);
        getServer().getPluginManager().registerEvents((Listener) new aotv(), this);
        getServer().getPluginManager().registerEvents((Listener) new aotvblock(), this);
        getServer().getPluginManager().registerEvents((Listener) new aotelephant(), this);
        getServer().getPluginManager().registerEvents((Listener) new withercloak(), this);
        getServer().getPluginManager().registerEvents((Listener) new ediblemace(), this);
        getServer().getPluginManager().registerEvents((Listener) new OpenFloor(), this);
        getServer().getPluginManager().registerEvents((Listener) new FloorSelection(), this);
        getServer().getPluginManager().registerEvents((Listener) new WorldGuard(), this);
        getServer().getPluginManager().registerEvents((Listener) new ScoreboardObjects(), this);
        getServer().getPluginManager().registerEvents((Listener) new NecronLoot(), this);
        getServer().getPluginManager().registerEvents((Listener) new BoneMerang(), this);
        getServer().getPluginManager().registerEvents((Listener) new Secrets(), this);
        getServer().getPluginManager().registerEvents((Listener) new NecronBoss(), this);
        getServer().getPluginManager().registerEvents((Listener) new CraftingEvents(), this);
        getServer().getPluginManager().registerEvents((Listener) new DamageEvents(), this);
        getServer().getPluginManager().registerEvents((Listener) new Terminals(), this);
        getServer().getPluginManager().registerEvents((Listener) new CustomDamage(), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[DungeonServerPlugin]: Plugin has been disabled!");
    }
}
