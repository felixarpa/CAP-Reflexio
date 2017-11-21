import java.lang.reflect.*;

/*
Donat el (fully qualified) nom d'una classe com a argument del programa, trobar informació dels mètodes
propis o heretats (atenció a la crida recursiva de la funció printMethods) de la classe
*/

public class ProvaMetodes {
    public static void main(String args[])
    {
	try {
	    printMethods(Class.forName(args[0]));
	}
	catch (Throwable e) {
            System.err.println(e);
	}
    }

    private static void printMethods (Class c) {
	if (c != null) {
	    try {
		Method m[] = c.getDeclaredMethods();
		for (int i = 0; i < m.length; i++)
		    System.out.println(m[i].toString());
		printMethods (c.getSuperclass());
	    }
	    catch (Throwable e) {
		System.err.println(e);
	    }	
	}
    }
}
