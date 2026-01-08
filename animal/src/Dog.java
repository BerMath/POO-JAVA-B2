public class Dog extends Animals{

    public Dog(int age, String name) {
        super(age, name, "wouaf");
    }

    @Override
    public void makeEat(){
        System.out.println("le chien un autre chien");
    }
}
