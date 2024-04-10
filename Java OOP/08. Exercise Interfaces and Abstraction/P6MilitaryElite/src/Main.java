import entities.*;
import enums.Corps;
import enums.State;
import interfaces.Private;
import interfaces.Soldier;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //List<Soldier> soldiersList = new ArrayList<>();
        Map<Integer, Soldier> soldierMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String rank = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (rank) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                    soldierMap.put(id, priv);
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < tokens.length; i++) {
                        int idToLookFor = Integer.parseInt(tokens[i]);
                        var soldier = soldierMap.get(idToLookFor);
                        lieutenantGeneral.addPrivate(soldier);
                    }

                    soldierMap.put(id, lieutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corpAsString = tokens[5];
                    if (Corps.Marines.toString().equals(corpAsString) || Corps.Airforces.toString().equals(corpAsString)) {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corpAsString);

                        for (int i = 6; i < tokens.length; i+=2) {
                            String partName = tokens[i];
                            int hoursWorked = Integer.parseInt(tokens[i+1]);

                            RepairImpl repair = new RepairImpl(partName, hoursWorked);
                            engineer.addRepair(repair);
                        }
                        soldierMap.put(id, engineer);
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corpAsString = tokens[5];
                    if (Corps.Marines.toString().equals(corpAsString) || Corps.Airforces.toString().equals(corpAsString)) {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corpAsString);

                        for (int i = 6; i < tokens.length; i+=2) {
                            String name = tokens[i];
                            String state = tokens[i + 1];
                            if (State.finished.toString().equals(state) || State.inProgress.toString().equals(state)) {
                                MissionImpl mission = new MissionImpl(name, state);
                                commando.addMission(mission);
                            }
                        }
                        soldierMap.put(id, commando);
                    }
                    break;
                case "Spy":
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, tokens[4]);
                    soldierMap.put(id, spy);
                    break;
            }

            input = scanner.nextLine();
        }

        for (var soldier : soldierMap.values()) {
            System.out.println(soldier.toString());
        }
    }
}