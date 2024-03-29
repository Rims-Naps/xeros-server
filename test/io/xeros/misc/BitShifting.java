package io.Odyssey.misc;

import io.Odyssey.content.combat.formula.rework.RangeCombatFormula;
import io.Odyssey.model.collisionmap.Region;
import io.Odyssey.model.collisionmap.RegionProvider;
import io.Odyssey.model.entity.player.Position;
import io.Odyssey.util.XORShiftRandom;
import org.apache.commons.codec.binary.Hex;

/**
 * @author Arthur Behesnilian 7:45 PM
 */
public class BitShifting {

    public static int[] positionFlags = { 0x128010e, 0x1280183, 0x1280138, 0x12801e0, 0x1280108, 0x1280102, 0x1280180, 0x1280120 };

    public static int[] projectileFlags = { 0x1280120, 0x1280180, 0x1280102, 0x1280108, 0x12801e0,
            0x1280138, 0x1280183, 0x128010e };

    public static void main(String[] args) {

        int max = 32;
        for (int x =0; x < 1000; x++) {
            System.out.println(XORShiftRandom.rand.nextInt(max));
        }

    }

}
