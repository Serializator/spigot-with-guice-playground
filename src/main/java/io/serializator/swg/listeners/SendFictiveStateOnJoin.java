package io.serializator.swg.listeners;

import com.google.inject.Inject;
import io.serializator.swg.state.FictiveStateManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Responsible for sending a message with the state of the minigame when they join
 */
public class SendFictiveStateOnJoin implements Listener {
    private final FictiveStateManager stateManager;

    @Inject
    public SendFictiveStateOnJoin(FictiveStateManager stateManager) {
        this.stateManager = stateManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GRAY + "We're currently -> \"" + stateManager.getState() + "\"");
    }
}
