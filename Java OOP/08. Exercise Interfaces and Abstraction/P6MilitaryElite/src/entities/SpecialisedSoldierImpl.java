package entities;

import enums.Corps;
import interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;
    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }
    private void setCorps(String corps) {
        this.corps = Corps.valueOf(corps);
    }
}
