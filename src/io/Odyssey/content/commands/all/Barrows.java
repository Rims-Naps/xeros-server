package io.Odyssey.content.commands.all;

import java.util.Optional;

import io.Odyssey.content.commands.Command;
import io.Odyssey.model.entity.player.Player;

/**
 * Changes the password of the player.
 * 
 * @author Emiel
 *
 */
public class Barrows extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		if (c.getPosition().inWild()) {
			c.sendMessage("You can only use this command outside the wilderness.");
			return;
		}
		c.getPA().startTeleport(3565, 3316, 0, "modern", false);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Takes you to barrows.");
	}
}
