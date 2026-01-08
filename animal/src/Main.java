public class Main{
    public static void main(String[] args){
        Cow cow = new Cow(6,"michel");
        Dog dog = new Dog(8,"jean");
        cow.makeNoise();
        dog.makeNoise();
        System.out.println(cow.getName());
        Animals.displayCommonInformation();
        cow.makeEat();
        dog.makeEat();

    }
}