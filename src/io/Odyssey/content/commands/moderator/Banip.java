package io.Odyssey.content.commands.moderator;

import java.util.List;
import java.util.stream.Collectors;

import io.Odyssey.Server;
import io.Odyssey.content.commands.Command;
import io.Odyssey.model.entity.player.Player;
import io.Odyssey.model.entity.player.PlayerHandler;
import io.Odyssey.model.entity.player.Right;
import io.Odyssey.model.multiplayersession.MultiplayerSession;
import io.Odyssey.model.multiplayersession.MultiplayerSessionFinalizeType;
import io.Odyssey.punishments.Punishment;
import io.Odyssey.punishments.PunishmentType;
import io.Odyssey.punishments.Punishments;

/**
 * Ban a given IP.
 * 
 * @author Emiel
 */
public class Banip extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		try {
			String[] args = input.split("-");
			if (args.length != 2) {
				throw new IllegalArgumentException();
			}
			String ipToBan = args[0];
			String reason = args[1];

			Punishments punishments = Server.getPunishments();
			punishments.add(new Punishment(PunishmentType.NET_BAN, Long.MAX_VALUE, ipToBan));

			List<Player> clientList = PlayerHandler.nonNullStream().filter(player -> player.connectedFrom.equals(ipToBan)).collect(Collectors.toList());
			
			if (punishments.contains(PunishmentType.NET_BAN, ipToBan)) {
				c.sendMessage("This ip is already banned.");
				return;
			}

			for (Player c2 : clientList) {
				if (c2.getRights().isOrInherits(Right.ADMINISTRATOR) && !c.getRights().isOrInherits(Right.OWNER)) {
					continue;
				}
				punishments.add(new Punishment(PunishmentType.BAN, Long.MAX_VALUE, c2.getLoginName()));
				if (Server.getMultiplayerSessionListener().inAnySession(c2)) {
					MultiplayerSession session = Server.getMultiplayerSessionListener().getMultiplayerSession(c2);
					session.finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
				}
				c2.forceLogout();
				c.sendMessage("You have IP banned the user: " + c2.getDisplayName() + " with the host: " + c2.connectedFrom);
			}

			c.sendMessage("You have successfully banned the IP: " + ipToBan);
			// TODO: Log handling
		} catch (Exception e) {
			c.sendMessage("Error. Correct syntax: ::banip-ip-reason");
		}
	}
}
