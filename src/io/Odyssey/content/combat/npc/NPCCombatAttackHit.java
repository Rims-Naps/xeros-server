package io.Odyssey.content.combat.npc;

import io.Odyssey.content.combat.CombatHit;
import io.Odyssey.model.entity.Entity;
import io.Odyssey.model.entity.npc.NPC;

public class NPCCombatAttackHit extends NPCCombatAttack {

    public static NPCCombatAttackHit of(NPCCombatAttack attack, CombatHit hit) {
        return new NPCCombatAttackHit(attack.getNpc(), attack.getVictim(), hit);
    }

    private final CombatHit combatHit;

    public NPCCombatAttackHit(NPC npc, Entity entity, CombatHit combatHit) {
        super(npc, entity);
        this.combatHit = combatHit;
    }

    public CombatHit getCombatHit() {
        return combatHit;
    }
}
