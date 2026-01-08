public class Cow extends Animals implements Pet{
    public Cow(int age, String name){
        super(age, name, "meuu");
    }

    @Override
    public void makeEat(){
        System.out.println("la vache un chat");
    }

    @Override
    public void play() {
        System.out.println("la vache joue dans l'herbe");
    }
}