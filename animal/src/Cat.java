public class Cat extends Animals implements Pet, Wild {

    public Cat(int age, String name) {
        super(age, name, "miaou");
    }

    @Override
    public void makeEat() {
        System.out.println("le chat mange des croquettes");
    }

    @Override
    public void play() {
        System.out.println("le chat joue avec une pelote de laine");
    }

    @Override
    public void hunt() {
        System.out.println("le chat chasse une souris");
    }
}