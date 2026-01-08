import java.util.ArrayList;

public class Owner {
    private String name;
    private ArrayList<Animals> animals;

    public Owner(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Animals> getAnimals() {
        return animals;
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animals animal) {
        animals.remove(animal);
    }
}

