package entities;

import interfaces.LieutenantGeneral;
import interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Collection<Private> privates;
    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        for (Private priv : privates) {
            sb.append(" ").append(priv.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
