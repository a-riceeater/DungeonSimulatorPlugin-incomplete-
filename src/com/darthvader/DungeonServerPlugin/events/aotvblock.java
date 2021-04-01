package com.darthvader.DungeonServerPlugin.events;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class aotvblock implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.ASPECT_OF_THE_VADER.getItemMeta())) {
                    Player player = event.getPlayer();
                    player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100, 100);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 8));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 225));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 8));
                }
            }
        }
    }
}
