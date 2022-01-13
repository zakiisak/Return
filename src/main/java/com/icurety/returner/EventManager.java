package com.icurety.returner;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventManager implements Listener {

    public void onPlayerRespawn(PlayerRespawnEvent event) {
        event.getPlayer().sendMessage("You can return to your deaht location by entering " + ChatColor.ITALIC + "/return." + ChatColor.ITALIC + ". Note that this will damage you quite ");
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            Player player = (Player) event.getEntity();
            DeathRegistry.registerDeath(player, player.getLocation());
        }
    }
}
