package entities;

import interfaces.Commando;
import interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Mission> missions;
    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(getCorps()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        for (Mission mission : missions) {
            sb.append(" ").append(mission.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
