package interfaces;

import java.util.Collection;

public interface LieutenantGeneral {
    void addPrivate(Soldier priv);
    Collection<Soldier> getPrivates();
}
