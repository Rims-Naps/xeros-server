package io.Odyssey.content.commands.moderator;

import io.Odyssey.content.commands.Command;
import io.Odyssey.content.tournaments.TourneyManager;
import io.Odyssey.content.worldevent.WorldEventContainer;
import io.Odyssey.content.worldevent.impl.TournamentWorldEvent;
import io.Odyssey.model.entity.player.Player;

/**
 * 
 * @author Grant_ | www.rune-server.ee/members/grant_ | 10/3/19
 *
 */
public class Mstarttourney extends Command {

	@Override
	public void execute(Player player, String commandName, String input) {
		if (TourneyManager.getSingleton().setNextTourneyType(input)) {
			WorldEventContainer.getInstance().startEvent(new TournamentWorldEvent());
			player.sendMessage("The tournament is about to begin, please allow up to 30 seconds..");
		} else {
			player.sendMessage("The tournament won't start because you entered an invalid tournament type.");
			player.sendMessage("Types: " + String.join(", ", TourneyManager.tourneyOrder));
		}
	}
}
