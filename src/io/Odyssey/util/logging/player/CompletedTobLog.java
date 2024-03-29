package io.Odyssey.util.logging.player;

import io.Odyssey.content.instances.InstancedArea;
import io.Odyssey.model.entity.player.Player;
import io.Odyssey.util.logging.PlayerLog;

import java.util.Set;
import java.util.stream.Collectors;

public class CompletedTobLog extends PlayerLog {

    private final InstancedArea instance;

    public CompletedTobLog(Player player, InstancedArea instance) {
        super(player);
        this.instance = instance;
    }

    @Override
    public Set<String> getLogFileNames() {
        return Set.of("completed_tob");
    }

    @Override
    public String getLoggedMessage() {
        String players = "";
        if (instance != null) {
            players = instance.getPlayers().stream().map(Player::getLoginNameLower).collect(Collectors.joining(", "));
        }
        return "Completed tob with " + players;
    }
}
