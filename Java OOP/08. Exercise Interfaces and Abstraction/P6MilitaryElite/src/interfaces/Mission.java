package interfaces;

import enums.State;

public interface Mission {
    String getCodeName();
    State getState();
    void completeMission();
}
