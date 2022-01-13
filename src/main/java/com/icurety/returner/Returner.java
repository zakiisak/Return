package com.icurety.returner;

import jdk.jfr.Event;
import org.bukkit.plugin.java.JavaPlugin;

public final class Returner extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new EventManager(), this);
        this.getCommand("return").setExecutor(new CommandReturn());
        this.getCommand("gohome").setExecutor(new CommandGoHome());
        this.getCommand("lastDeath").setExecutor(new CommandLastDeath());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
