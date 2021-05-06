package com.danieldusek.godall.commands;

import com.danieldusek.godall.Constants;
import com.danieldusek.godall.GodAll;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GodAllCommand implements CommandExecutor {
    private GodAll i;



    public GodAllCommand(Plugin plugin) {
        this.i = (GodAll) plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission(Constants.USE_PERMISSION_NODE)) {
            sender.sendMessage(Constants.MESSAGE_NO_PERMISSIONS);
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(Constants.MESSAGE_USE);
            return true;
        }


        for (Player player : Bukkit.getOnlinePlayers()) {
            if (args[0].equalsIgnoreCase(Constants.ON_TOGGLE)) {
                player.setInvulnerable(true);
                player.sendMessage(Constants.MESSAGE_ENABLED);
            } else if (args[0].equalsIgnoreCase(Constants.OFF_TOGGLE)) {
                player.setInvulnerable(false);
                player.sendMessage(Constants.MESSAGE_DISABLED);
            } else {
                return false;
            }
        }

        return true;
    }
}
