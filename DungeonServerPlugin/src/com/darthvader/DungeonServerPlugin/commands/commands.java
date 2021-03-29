package com.darthvader.DungeonServerPlugin.commands;

import com.darthvader.DungeonServerPlugin.DungeonServerPlugin;
import com.darthvader.DungeonServerPlugin.guis.ItemSelections;
import com.darthvader.DungeonServerPlugin.guis.bazaar;
import com.darthvader.DungeonServerPlugin.items.ItemManager;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class commands implements CommandExecutor {
    private DungeonServerPlugin plugin;

    public commands() {
        plugin = DungeonServerPlugin.getPlugin(DungeonServerPlugin.class);
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("gmc")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage("Your gamemode has been updated to creative");
        }
        if (cmd.getName().equalsIgnoreCase("gms")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage("Your gamemode has been updated to survival");
        }
        if (cmd.getName().equalsIgnoreCase("gmsp")) {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Your gamemode has been updated to spectator");
        }
        if (cmd.getName().equalsIgnoreCase("givehyperion")) {
            player.getInventory().addItem(ItemManager.hyperion);
        }
        if (cmd.getName().equalsIgnoreCase("items")) {
            ItemSelections gui = new ItemSelections();
            player.openInventory(gui.getInventory());
        }
        if (cmd.getName().equalsIgnoreCase("shadowassasin")) {
            player.getInventory().addItem(ItemManager.SA_HELMET);
            player.getInventory().addItem(ItemManager.SA_CHESTPLATE);
            player.getInventory().addItem(ItemManager.SA_LEGGINGS);
            player.getInventory().addItem(ItemManager.SA_SHOES);
        }
        if (cmd.getName().equalsIgnoreCase("bz")) {
            bazaar gui = new bazaar();
            player.openInventory(gui.getInventory());
        }
        if (cmd.getName().equalsIgnoreCase("rougesword")) {
            player.getInventory().addItem(ItemManager.ROUGE_SWORD);
        }
        if (cmd.getName().equalsIgnoreCase("aote")) {
            player.getInventory().addItem(ItemManager.ASPECT_OF_THE_END);
        }
        if (cmd.getName().equalsIgnoreCase("aotd")) {
            player.getInventory().addItem(ItemManager.ASPECT_OF_THE_DRAGONS);
        }
        if (cmd.getName().equalsIgnoreCase("heal")) {
            player.setHealth(player.getMaxHealth());
            player.setFoodLevel(20);
            player.sendMessage("§9You have been healed!");
        }
        if (cmd.getName().equalsIgnoreCase("aotv")) {
            player.getInventory().addItem(ItemManager.ASPECT_OF_THE_VADER);
        }
        if (cmd.getName().equalsIgnoreCase("aotelephant")) {
            player.getInventory().addItem(ItemManager.ASPECT_OF_THE_ELEPHANT);
        }
        if (cmd.getName().equalsIgnoreCase("withercloak")) {
            player.getInventory().addItem(ItemManager.WITHER_CLOAK_SWORD);
        }
        if (cmd.getName().equalsIgnoreCase("handle")) {
            player.getInventory().addItem(ItemManager.NECRONS_HANDLE);
        }
        if (cmd.getName().equalsIgnoreCase("emeraldblade")) {
            player.getInventory().addItem(ItemManager.EMERALD_BLADE);
        }
        if (cmd.getName().equalsIgnoreCase("mace")) {
            player.getInventory().addItem(ItemManager.EDIBLE_MACE);
        }
        if (cmd.getName().equalsIgnoreCase("brodcast")) {
            player.getServer().broadcastMessage("[§cBRODCAST§f] " + args[0]);
        }
        if (cmd.getName().equalsIgnoreCase("nick")) {
            player.setDisplayName(args[0]);
            player.sendMessage("Set your nickname to " + args[0] + "!");
        }
        if (cmd.getName().equalsIgnoreCase("nickreset")) {
            player.kickPlayer("§aReset your nickname! \n§bPlease reconnect for the change to take action!");
        }
        if (cmd.getName().equalsIgnoreCase("bone")) {
            player.getInventory().addItem(ItemManager.BONEMERANG);
        }
        if (cmd.getName().equalsIgnoreCase("necron")) {
            Wither wither = (Wither) player.getWorld().spawnEntity(player.getLocation(), EntityType.WITHER);
            wither.setMaxHealth(2048);
            wither.setHealth(2048);
            wither.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1734000, 2));
            wither.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1734000, 2));
            wither.setCustomName("§cNecron");
        }
        if (cmd.getName().equalsIgnoreCase("ban")) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            target.kickPlayer("Reason");
            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "Reason: " + args[1], null, null);

        }
        if (cmd.getName().equalsIgnoreCase("unban")) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            Bukkit.getBanList(BanList.Type.NAME).pardon(target.getName());
        }
        if (cmd.getName().equalsIgnoreCase("deathbow")) {
            player.getInventory().addItem(ItemManager.DEATH_BOW);
        }
        if (cmd.getName().equalsIgnoreCase("golem")) {
            IronGolem wither = (IronGolem) player.getWorld().spawnEntity(player.getLocation(), EntityType.IRON_GOLEM);
            wither.setMaxHealth(1000);
            wither.setHealth(1000);
        }
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (plugin.fly.contains(player.getUniqueId())) {
                plugin.fly.remove(player.getUniqueId());
                player.setAllowFlight(false);
            }
            else {
                plugin.fly.add(player.getUniqueId());
                player.setAllowFlight(true);
            }
        }
        if (cmd.getName().equalsIgnoreCase("la")) {
            ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                armorStand.getEquipment().setHelmet(ItemManager.SA_HELMET);
                armorStand.getEquipment().setChestplate(ItemManager.SA_CHESTPLATE);
                armorStand.getEquipment().setLeggings(ItemManager.SA_LEGGINGS);
                armorStand.getEquipment().setBoots(ItemManager.SA_SHOES);
                armorStand.setMaxHealth(100);
                armorStand.setHealth(100);
                armorStand.setCustomName("§6Lost Adventurer");
                armorStand.setCustomNameVisible(true);
            Spider spider = (Spider) player.getWorld().spawnEntity(player.getLocation(), EntityType.SPIDER);
            spider.setMaxHealth(2048);
            spider.setHealth(2048);
            spider.setInvisible(true);
            spider.setInvulnerable(true);
            Bukkit.getScheduler().scheduleSyncRepeatingTask(DungeonServerPlugin.getPlugin(DungeonServerPlugin.class), () -> armorStand.teleport(spider.getLocation()), 0L, 1);
        }
        if (cmd.getName().equalsIgnoreCase("zombiesword")) {
            player.getInventory().addItem(ItemManager.ZOMBIE_SWORD);
        }
        return true;
    }
}
