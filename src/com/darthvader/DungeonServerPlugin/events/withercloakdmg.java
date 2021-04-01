package com.darthvader.DungeonServerPlugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class withercloakdmg implements Listener {
    @EventHandler
    public void onClick(EntityDamageEvent e) {
        if (e instanceof Player) {
            Player player = ((Player) e).getPlayer();
            PotionEffect effect = player.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            if (effect != null && effect.getAmplifier() == 225) {
                player.sendMessage("§6 - 10 Mana §b");
            }
        }
    }
}
