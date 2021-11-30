package sample;

public class main {
    public static void main(String[] args) {
        ArbreInt arbre = new ArbreInt(new ArbreInt(new ArbreInt(), 2, new ArbreInt(33)), 5,
                new ArbreInt(new ArbreInt(6), 8,
                        new ArbreInt(new ArbreInt(9), 10, new ArbreInt())));

        arbre.parcoursPostfixe();
    }

}
