package io.Odyssey.content;

import java.util.List;

import com.google.common.collect.Lists;
import io.Odyssey.model.entity.player.Player;
import io.Odyssey.model.entity.player.PlayerHandler;
import io.Odyssey.net.discord.DiscordMessager;
import io.Odyssey.util.discord.Discord;

public class Censor {

    private static final List<String> CENSORED = Lists.newArrayList(
            "wisdomrsps", "vengeanceps",  "redemptionrsps", "ikov", "zaros",
            "nigger", "nigga", "niger", "niggr", "nigr", "niggar", "niggas", "niggers", "nggr", 
            "pedophile", "pedofile",
            "retard", "rtard",
            "autistic", "autist",
            "fagot", "faggot", "fag"
    );

    public static boolean isCensoredName(String name) {
        String _name = name.toLowerCase();
        return CENSORED.stream().anyMatch(_name::contains);
    }

    public static boolean isCensored(Player player, String message) {
        if (player.getRights().hasStaffPosition()) {
            return false;
        }

        message = message.toLowerCase();
        for (String censor : CENSORED) {
            if (message.contains(censor)) {
                DiscordMessager.sendLogs("Player [" + player.getDisplayName() + "] was muted for 5 minutes for saying: " + censor);
                player.sendMessage("@red@[WARNING]@bla@ You are not allowed to say " + censor +", you have been muted for 5 minutes.");
                player.sendMessage("@red@[WARNING]@bla@ Staff have been notified, please do not use this language again.");
                PlayerHandler.executeGlobalStaffMessage("[@red@Staff Message@bla@] <col=255>" + player.getDisplayName() + " has been muted for saying "+ censor +"");

                player.muteEnd = System.currentTimeMillis() + (60_000 * 5);
                return true;
            }
        }

        return false;
    }

}
