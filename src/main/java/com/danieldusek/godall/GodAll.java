package com.danieldusek.godall;

import com.danieldusek.godall.commands.GodAllCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class GodAll extends JavaPlugin {



    @Override
    public void onEnable() {
        getCommand("godall").setExecutor(new GodAllCommand(this));
    }

    @Override
    public void onDisable() {}
}
