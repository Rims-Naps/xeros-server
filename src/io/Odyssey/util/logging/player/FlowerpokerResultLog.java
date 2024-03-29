package io.Odyssey.util.logging.player;

import io.Odyssey.model.entity.player.Player;
import io.Odyssey.model.items.GameItem;
import io.Odyssey.util.logging.PlayerLog;

import java.util.List;
import java.util.Set;

public class FlowerpokerResultLog extends PlayerLog {

    private final String plantedWithLoginName;
    private final String otherPlanted;
    private final String playerPlanted;

    public FlowerpokerResultLog(Player player, String tradedWithLoginName, String otherPlanted, String playerPlanted) {
        super(player);
        this.plantedWithLoginName = tradedWithLoginName;
        this.otherPlanted = otherPlanted;
        this.playerPlanted = playerPlanted;
    }

    @Override
    public Set<String> getLogFileNames() {
        return Set.of("flower_poker_result");
    }

    @Override
    public String getLoggedMessage() {
        return String.format("Flower pokered: [%s] (login name) planted [%s] and I planted [%s]", plantedWithLoginName, otherPlanted, playerPlanted);
    }
}
