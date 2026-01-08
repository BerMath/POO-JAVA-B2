public class Cow extends Animals{
    public Cow(int age, String name){
        super(age, name, "meuu");
    }

    @Override
    public void makeEat(){
        System.out.println("la vache un chat");
    }
}