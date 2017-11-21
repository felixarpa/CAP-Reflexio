import java.lang.reflect.*;

/*
Donat el (fully qualified) nom d'una classe com a argument del programa, trobar informació dels mètodes
i atributs (fields) propis o heretats (atenció a la crida recursiva de la funció printMethodAndFieldsWithValues) de
la classe. A més, escric els valors de les constants (atributs final i static), siguin privades o no.
*/


public class ProvaAmbValors {
    public static void main(String args[]) {
        try {
            printMethodsAndFieldsWithValues(Class.forName(args[0]));
        }
        catch (Throwable e) {
                System.err.println(e);
        }
    }

    private static void printMethodsAndFieldsWithValues (Class c) {
        if (c != null) {
            try {
                Method m[] = c.getDeclaredMethods();
                Field f[] = c.getDeclaredFields();
                for (int i = 0; i < m.length; i++) {
                    System.out.println(m[i].toString());
                }
                for (int i = 0; i < f.length; i++) {
                    System.out.print(f[i].toString());
                    if (Modifier.isStatic(f[i].getModifiers()) &&
                        Modifier.isFinal(f[i].getModifiers())) {
                        f[i].setAccessible(true); // per si de cas és privat
                        System.out.println(" = " + f[i].get(null)); // és static, d'aquí el null
                    } else {
                        System.out.println();
                    }
                }
                printMethodsAndFieldsWithValues (c.getSuperclass());
            }
            catch (Throwable e) {
                System.err.println(e);
            }   
        }
    }
}
