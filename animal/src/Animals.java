public class Animals {
    private int age;
    private String name;
    private String sound;

    public Animals (int age, String name, String sound){
        this.age = age;
        this.name = name;
        this.sound = sound;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void makeNoise(){
        System.out.println(sound);
    }

    public static void displayCommonInformation(){
        System.out.println("Sounds of all animals");
    }
}

