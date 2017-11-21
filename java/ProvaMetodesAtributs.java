import java.lang.reflect.*;

/*
Donat el (fully qualified) nom d'una classe com a argument del programa, trobar informació dels mètodes
i atributs (fields) propis o heretats (atenció a la crida recursiva de la funció printMethodAndFields) de
la classe
*/

public class ProvaMetodesAtributs {
    public static void main(String args[])
    {
	try {
	    printMethodsAndFields(Class.forName(args[0]));
	}
	catch (Throwable e) {
            System.err.println(e);
	}
    }

    private static void printMethodsAndFields (Class c) {
	if (c != null) {
	    try {
		Method m[] = c.getDeclaredMethods();
		Field f[] = c.getDeclaredFields();
		for (int i = 0; i < m.length; i++)
		    System.out.println(m[i].toString());
		for (int i = 0; i < f.length; i++)
		    System.out.println(f[i].toString());
		printMethodsAndFields (c.getSuperclass());
	    }
	    catch (Throwable e) {
		System.err.println(e);
	    }	
	}
    }
}
