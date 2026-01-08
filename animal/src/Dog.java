public class Dog extends Animals implements Pet{

    public Dog(int age, String name) {
        super(age, name, "wouaf");
    }

    @Override
    public void makeEat(){
        System.out.println("le chien un autre chien");
    }

    @Override
    public void play() {
        System.out.println("wow le chien avec la baballe");
        System.out.println("le chien est si fatigué qu'il va dormir sur les jambes de gauthier");
    }
}
