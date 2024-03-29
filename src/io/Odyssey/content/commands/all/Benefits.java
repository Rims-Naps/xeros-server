package io.Odyssey.content.commands.all;

import java.util.Optional;

import io.Odyssey.content.commands.Command;
import io.Odyssey.model.entity.player.Player;

/**
 * Open the forums in the default web browser.
 * 
 * @author Emiel
 */
public class Benefits extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		  c.getPA()
          .sendFrame126(
                  "https://www.Odyssey.io/index.php?/topic/14-donator-benefits-guide/", 12000);
}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Opens a web page with donator benefits");
	}

}
