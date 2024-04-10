package entities;

import interfaces.LieutenantGeneral;
import interfaces.Private;
import interfaces.Soldier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Collection<Soldier> privates;
    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Soldier priv) {
        this.privates.add(priv);
    }

    @Override
    public Collection<Soldier> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        for (Soldier priv : privates) {
            sb.append(" ").append(priv.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
