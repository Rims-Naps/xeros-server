package io.Odyssey.content.commands.all;

import java.util.Optional;

import io.Odyssey.content.commands.Command;
import io.Odyssey.content.vote_panel.VotePanelInterface;
import io.Odyssey.model.entity.player.Player;


public class Vpanel extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        VotePanelInterface.openInterface(c, true);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.of("Opens your vote panel.");
    }

}
