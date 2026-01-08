public class Dog extends Animals implements Pet{

    public Dog(int age, String name) {
        super(age, name, "woof");
    }

    @Override
    public void makeEat(){
        System.out.println("le chien mange des croquettes");
    }

    @Override
    public void play() {
        System.out.println("le chien joue avec la balle");
    }
}