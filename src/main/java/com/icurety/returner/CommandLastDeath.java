package com.icurety.returner;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLastDeath implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            Location location = DeathRegistry.getLatestDeath(player);
            if(location != null)
            {
                sender.sendMessage("Your last death location was " + location.getX() + ", " + location.getY() + ", " + location.getZ());
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
