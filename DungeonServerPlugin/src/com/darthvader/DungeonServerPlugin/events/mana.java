package com.darthvader.DungeonServerPlugin.events;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mana implements Listener {
    private DungeonServerPlugin plugin;

    public mana() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        plugin.mana.put(e.getPlayer().getUniqueId(), plugin.maxmana.get(e.getPlayer().getUniqueId()) / 2);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), new Runnable() {
            @Override
            public void run() {
                Player player = e.getPlayer();
                plugin.maxmana.put(player.getUniqueId(), 100);
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
                Score score01 = objective.getScore(ChatColor.GRAY + format.format(now));
                score01.setScore(1);
                Score score = objective.getScore("§9Mana: " + ChatColor.BLUE + plugin.mana.get(player.getUniqueId()) + "§9/" + plugin.mana.get(player.getUniqueId()));
                score.setScore(0);
                player.setScoreboard(board);
            }
        }, 0L, 20L); //0 Tick initial delay, 20 Tick (1 Second) between repeats
    }
}