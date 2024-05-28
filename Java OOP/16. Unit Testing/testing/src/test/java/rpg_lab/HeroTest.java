package rpg_lab;

import org.example.rpg_lab.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private final static int TARGET_XP = 10;
    private final static int WEAPON_ATTACK = 10;
    private final static String HERO_NAME = "Hero";
    private Dummy dummy;
    private Axe axe;
    private Hero hero;
    Weapon weaponMock;
    Target targetMock;
    @Before
    public void setUp() {
        weaponMock = Mockito.mock(Weapon.class);
        targetMock = Mockito.mock(Target.class);
        Mockito.when(this.targetMock.isDead()).thenReturn(true);
        Mockito.when(this.targetMock.giveExperience()).thenReturn(TARGET_XP);

        this.hero = new Hero(HERO_NAME, weaponMock);
    }
    @Test
    public void heroGainsExperienceAfterAttackIfTargetDies() {
        this.hero.attack(this.targetMock);

        Assert.assertEquals("Wrong experience", TARGET_XP, this.hero.getExperience());
    }
}
