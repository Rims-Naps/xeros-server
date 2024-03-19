package io.Odyssey.content.commands.owner;

import io.Odyssey.content.commands.Command;
import io.Odyssey.model.entity.player.Player;

public class Getclip extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		String[] args = input.split(" ");
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);
		System.out.println("Clip: " + c.getRegionProvider().getClipping(x, y, z));
	}

}
