package entities;

import interfaces.Engineer;
import interfaces.Mission;
import interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(getCorps()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : repairs) {
            sb.append(" ").append(repair.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
