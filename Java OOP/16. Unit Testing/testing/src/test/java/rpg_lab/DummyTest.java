package rpg_lab;

import org.example.rpg_lab.Axe;
import org.example.rpg_lab.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private final static int DUMMY_HEALTH = 20;
    private final static int DEAD_DUMMY_HEALTH = 0;
    private final static int DUMMY_XP = 10;
    private final static int ATTACK_POINTS = 5;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void initializeTestObjects() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_XP);
    }
    @Test
    public void dummyLosesHealth() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsException() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }
    @Test
    public void deadDummyGiveXP() {
        int exp = deadDummy.giveExperience();
        Assert.assertEquals(DUMMY_XP, exp);
    }
    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        int exp = dummy.giveExperience();
    }
}
