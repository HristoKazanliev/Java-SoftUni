package entities;

import enums.State;
import interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private State state;
    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }
    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    private void setState(String state) {
        this.state = State.valueOf(state);
    }

    @Override
    public void completeMission() {
        this.state = State.finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state.toString());
    }
}
