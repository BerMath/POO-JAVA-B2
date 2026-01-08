public class Main{
    public static void main(String[] args){
        Cow cow = new Cow(6,"michel");
        cow.makeNoise();
        System.out.println(cow.getName());
        Animals.displayCommonInformation();
    }
}