import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Owner owner = new Owner("Pierre");

        Cow cow = new Cow(6, "michel");
        Dog dog = new Dog(8, "jean");
        Cat cat = new Cat(3, "Felix");


        owner.addAnimal(cow);
        owner.addAnimal(dog);
        owner.addAnimal(cat);

        System.out.println("Propriétaire: " + owner.getName());
        System.out.println("Nombre d'animaux: " + owner.getAnimals().size());
        System.out.println();

        Animals.displayCommonInformation();

        cow.makeNoise();
        System.out.println(cow.getName());
        cow.makeEat();
        cow.makeEat(" l'herbe");

        dog.makeNoise();
        System.out.println(dog.getName());
        dog.makeEat();
        dog.makeEat(" dinde");
        dog.play();

        cow.play();


        cat.makeNoise();
        cat.hunt();
        cat.play();

        ArrayList<Animals> list = new ArrayList<>();
        list.add(cow);
        list.add(dog);
        list.add(cat);

        for (Animals animal : list) {
            animal.makeEat();
        }
    }
}