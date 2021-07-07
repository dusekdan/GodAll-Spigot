package com.danieldusek.godall.listeners;

import com.danieldusek.godall.Constants;
import com.danieldusek.godall.GodAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {
    final private GodAll i;


    public PlayerJoinListener(Plugin plugin) {
        this.i = (GodAll) plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        boolean enableGodForNewJoiners = i.getConfig().getBoolean("god-for-new-joiners", false);

        if (enableGodForNewJoiners) {
            Player player = event.getPlayer();
            if (this.i.godEnabled) {
                player.setInvulnerable(true);
                player.sendMessage(Constants.MESSAGE_ENABLED);
            } else {
                player.setInvulnerable(false);
                player.sendMessage(Constants.MESSAGE_DISABLED);
            }
        }
    }

}
