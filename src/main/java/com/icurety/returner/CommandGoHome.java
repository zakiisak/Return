package com.icurety.returner;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGoHome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            Location location = player.getBedSpawnLocation();
            if(location != null)
            {
                if(player.getLevel() >= 10)
                {
                    player.setLevel(player.getLevel() - 10);
                    player.teleport(location);
                }
                else sender.sendMessage("You must have 10 levels or more to execute this command");
            }
            else {
                sender.sendMessage("You don't have a spawn location");
            }
        }
        else {
            sender.sendMessage("You aren't a player on the server");
        }

        return true;
    }
}
