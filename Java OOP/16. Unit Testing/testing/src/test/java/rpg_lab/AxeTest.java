package rpg_lab;

import org.example.rpg_lab.Axe;
import org.example.rpg_lab.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private final static int AXE_ATTACK = 10;
    private final static int AXE_DURABILITY = 1;
    private final static int AXE_WITHOUT_DURABILITY = 0;
    private final static int DUMMY_HEALTH = 20;
    private final static int DUMMY_XP = 10;
    private final static int EXPECTED_DURABILITY = AXE_DURABILITY - 1;
    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_ATTACK, AXE_WITHOUT_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }
    @Test
    public void weaponLosesDurabilityAfterAttack() {
        //Act
        this.axe.attack(this.dummy);

        //Assert
        Assert.assertEquals("Wrong Durability, ", EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenWeaponShouldThrowException() {
        brokenAxe.attack(dummy);
    }
}
