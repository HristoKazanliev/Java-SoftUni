import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;
    public Team(String name) {
        this.setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }
    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }
    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeam.add(player);
        } else {
            this.reserveTeam.add(player);
        }
    }
}
