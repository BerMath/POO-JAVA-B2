public abstract class Animals {
    protected int age;
    protected String name;
    protected String sound;

    public Animals (int age, String name, String sound){
        this.age = age;
        this.name = name;
        this.sound = sound;
    }

    private int getAge(){
        return age;
    }

    String getName(){
        return name;
    }

    protected void makeNoise(){
        System.out.println(sound);
    }

    protected void makeEat(){
        System.out.println("est en train de manger");
    }

    protected void makeEat(String food){
        System.out.println("est en train de manger"+ food);
    }

    protected static void displayCommonInformation(){
        System.out.println("Sounds of all animals");
    }
}