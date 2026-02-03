public class Main {
    public static void main(String[] args) {

        Sandwich s1 = new SandwichBuilder("baguette")
                .viande("jambon")
                .fromage("emmental")
                .legumes("laitue", "tomate")
                .sauce("moutarde")
                .grille(true)
                .build();

        Sandwich s2 = new SandwichBuilder("ciabatta")
                .viande("poulet")
                .sauce("mayo")
                .build();

        Sandwich s3 = new SandwichBuilder("complet")
                .fromage("bleu")
                .legumes("laitue", "oignon", "cornichon")
                .build();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}