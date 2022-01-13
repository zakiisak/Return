package com.icurety.returner;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReturn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            Location location = DeathRegistry.getLatestDeath(player);
            if(location != null)
            {
                player.setHealth(2);
                player.teleport(location);
            }
            else {
                sender.sendMessage("You haven't died since this servers launch");
            }
        }
        else {
            sender.sendMessage("You aren't a player on the server");
        }

        return true;
    }
}
