import java.lang.reflect.*;

public class Reflexio {

    public static final String CURS = "CAP";
    public String nom = "Fèlix";

    public static void main(String[] args) {
        System.out.println("Exercici 2: ");
        exercici2(args[0]);
        System.out.println();
        System.out.println("Exercici 3: ");
        exercici3(args[0]);
        System.out.println();
        System.out.println("Exercici 4: ");
        exercici4(args[0]);
        System.out.println();
        System.out.println("Exemple Array: ");
        exempleArray();
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

    public static void exercici4(String nom) {
        try {
            Class c = Class.forName(nom);
            Field f[] = c.getFields();
            Method m[] = c.getMethods();
            System.out.println("Atributs:");
            for (int i = 0; i < f.length; i++) {
                System.out.println(f[i].toString());
            }
            System.out.println("Mètodes:");
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void exempleArray() {
        int dims[] = new int[] { 5, 10, 15 };
        Object array = Array.newInstance(int.class, dims); // int[5][10][15]
                                                           //     3
                                                           //     3   5
                                                           //     3   5  10

        Object arrayObject = Array.get(array, 0); // array[3]      -> arrayObject
        Class aClass = arrayObject.getClass().getComponentType();
        System.out.println(aClass);
        arrayObject = Array.get(arrayObject, 5); // array[3][5]    -> arrayObject
        Array.setInt(arrayObject, 10, 37);       // array[3][5][10] = 37
                                                 // arrayObject[10] = 37

        int arrayCast[][][] = (int[][][]) array;
        System.out.println(arrayCast[0][5][10]);
    }
}



