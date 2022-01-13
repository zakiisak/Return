package com.icurety.returner;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeathRegistry {

    private static Map<String, List<Location>> deathLocations = new HashMap<String, List<Location>>();

    public static void registerDeath(Player player, Location location)
    {
        if(deathLocations.containsKey(player.getUniqueId().toString()))
        {
            deathLocations.get(player.getUniqueId().toString()).add(location);
        }
        else {
            List<Location> list = new ArrayList<Location>();
            list.add(location);
            deathLocations.put(player.getUniqueId().toString(), list);
        }
    }

    public static Location getLatestDeath(Player player)
    {
        if(deathLocations.containsKey(player.getUniqueId().toString())) {
            List<Location> locations = deathLocations.get(player.getUniqueId().toString());
            return locations.get(locations.size() - 1);
        }
        return null;
    }


}
