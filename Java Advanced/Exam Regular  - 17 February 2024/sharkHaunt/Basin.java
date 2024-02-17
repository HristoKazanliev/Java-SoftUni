package sharkHaunt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (this.capacity > sharks.size()) {
            this.sharks.add(shark);
        }
    }

    public boolean removeShark(String kind) {
        Shark shark = this.sharks.stream()
                .filter(s -> s.getKind().equals(kind))
                .findFirst()
                .orElse(null);

        if (shark == null) {
            return false;
        }

        return this.sharks.remove(shark);
    }

    public Shark getLargestShark(){
        return this.sharks.stream().max(Comparator.comparingInt(Shark::getLength)).orElse(null);
    }

    public Shark getShark(String kind){
        return this.sharks.stream().filter(s -> s.getKind().equals(kind)).findFirst().orElse(null);
    }

    public int getCount(){
        return  this.sharks.size();
    }

    public int getAverageLength(){
        int sum = 0;
        for (Shark s : sharks) {
            sum += s.getLength();
        }

        return sum / sharks.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sharks in %s:", this.name));

        this.sharks.forEach(s -> {
            sb.append(System.lineSeparator());
            sb.append(s);
        });

        return sb.toString();
    }
}
