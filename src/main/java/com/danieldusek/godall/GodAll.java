package com.danieldusek.godall;

import com.danieldusek.godall.commands.GodAllCommand;
import com.danieldusek.godall.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GodAll extends JavaPlugin {
    // This setting does not aim to persist between server restarts
    // or reloads.
    public boolean godEnabled = false;

    @Override
    public void onEnable() {

        setupConfig();

        getCommand("godall").setExecutor(new GodAllCommand(this));

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

    }

    private void setupConfig() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {}
}
