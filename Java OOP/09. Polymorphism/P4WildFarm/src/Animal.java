public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;
    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }
    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }
    public abstract void makeSound();
    public void eat(Food food) {
        if (canEatFood(food)) {
            this.foodEaten += food.getQuantity();
        } else {
            System.out.printf("%ss are not eating that type of food!%n", getClass().getSimpleName());
        }
    }
    public abstract boolean canEatFood(Food food);
}
