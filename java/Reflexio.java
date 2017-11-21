import java.lang.reflect.*;

public class Reflexio {
    public static void main(String[] args) {
        System.out.println("Exercici 2: ");
        exercici2(args[0]);
        System.out.println();
        System.out.println("Exercici 3: ");
        exercici3(args[0]);
    }

    public static void exercici2(String nom) {
        try {
            Class c = Class.forName(nom);
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void exercici3(String nom) {
        try {
            Class c = Class.forName(nom);
            Method m[] = c.getMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}