package io.Odyssey.content.skills.slayer;

import io.Odyssey.content.dialogue.DialogueBuilder;
import io.Odyssey.model.AmountInput;
import io.Odyssey.model.Npcs;
import io.Odyssey.model.entity.player.Player;

public class KonarDialogue extends DialogueBuilder {

    private final Task task;

    public KonarDialogue(Player player, Task task) {
        super(player);
        this.task = task;
        KonarSlayer.assignKonarSlayer(player, task);
        setNpcId(Npcs.KONAR_QUO_MATEN);
        npc("Your are to bring balance to ", player.getSlayer().getTaskAmount() + " " + task.getFormattedName() + " in the " + player.getKonarSlayerLocation() + ".")
                .exit(plr -> { plr.getPA().closeAllWindows(); }
                );
    }

}
