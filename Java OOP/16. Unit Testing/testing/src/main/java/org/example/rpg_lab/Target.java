package org.example.rpg_lab;

public interface Target {
    int getHealth();
    int giveExperience();
    boolean isDead();
    void takeAttack(int attackPoints);
}
