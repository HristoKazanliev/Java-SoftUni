package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;
    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    private void setGender(String gender) {
        if (gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    public String produceSound() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                            "%s %d %s\n" +
                            "%s",this.getClass().getSimpleName(),
                            this.name,
                            this.age,
                            this.gender,
                            this.produceSound());
    }
}
