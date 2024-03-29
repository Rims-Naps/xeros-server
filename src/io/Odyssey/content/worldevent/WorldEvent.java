package io.Odyssey.content.worldevent;

import java.util.List;

import io.Odyssey.content.commands.Command;
import io.Odyssey.content.worldevent.impl.TournamentWorldEvent;
import io.Odyssey.model.entity.player.Player;

public interface WorldEvent {

    default boolean isOutlast() {
        return getClass().equals(TournamentWorldEvent.class);
    }

    void init();

    void dispose();

    boolean isEventCompleted();

    String getCurrentStatus();

    String getEventName();

    /**
     * Start description would be something like starts/spawns/begins in x minutes.
     */
    String getStartDescription();

    Class<? extends Command> getTeleportCommand();

    void announce(List<Player> players);
}
