package io.Odyssey.content.trails;

import io.Odyssey.util.Misc;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public enum RewardLevel {
	SHARED(-1, -1), // Not gonna remove this because collection log relies on it..
	EASY(TreasureTrails.EASY_CLUE_SCROLL, TreasureTrails.EASY_CASKET),
	MEDIUM(TreasureTrails.MEDIUM_CLUE_SCROLL, TreasureTrails.MEDIUM_CASKET),
	HARD(TreasureTrails.HARD_CLUE_SCROLL, TreasureTrails.HARD_CASKET),
	MASTER(TreasureTrails.MASTER_CLUE_SCROLL, TreasureTrails.MASTER_CASKET),
	//master = master
	TEAL(TreasureTrails.TEAL_AOD_CLUESCROLL, TreasureTrails.TEAL_AOD_CASKET),

	RED(TreasureTrails.RED_AOD_CASKET, TreasureTrails.RED_AOD_CASKET);

	public static final RewardLevel[] ALL = { RewardLevel.EASY, RewardLevel.MEDIUM, RewardLevel.HARD, RewardLevel.MASTER, RewardLevel.TEAL, RewardLevel.RED, };

	private final int clueScrollId;
	private final int casketId;

	RewardLevel(int clueScrollId, int casketId) {
		this.clueScrollId = clueScrollId;
		this.casketId = casketId;
	}

	public String getFormattedName() {
		return Misc.formatPlayerName(name().toLowerCase());
	}

	public int getClueScrollId() {
		return clueScrollId;
	}

	public int getCasketId() {
		return casketId;
	}
	
	public static final List<RewardLevel> VALUES = Arrays.asList(values());
	
	public static List<RewardLevel> getValues() {
		return VALUES;
	}
}
