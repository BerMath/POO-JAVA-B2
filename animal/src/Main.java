public class Main{
    public static void main(String[] args){
        Cow cow = new Cow(6,"michel");
        Dog dog = new Dog(8,"jean");
        Animals.displayCommonInformation();
        cow.makeNoise();
        System.out.println(cow.getName());
        cow.makeEat();
        cow.makeEat(" poulet");
        dog.makeNoise();
        System.out.println(dog.getName());
        dog.makeEat();
        dog.makeEat(" dinde");
        dog.play();

    }
}