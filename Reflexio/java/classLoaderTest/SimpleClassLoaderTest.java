import simpleClassLoader.*;
public class SimpleClassLoaderTest {
    
    public static void main( String[] args ) 
	throws ClassNotFoundException, 
	       InstantiationException, 
	       IllegalAccessException 
    {

	System.out.println("Creo el primer classloader i carrego ConstructOnce");
	SimpleClassLoader firstClassLoader 
	    = new SimpleClassLoader( "testclasses" );
	Class c1 = firstClassLoader.loadClass( "ConstructOnce" );

	System.out.println("Creo el segon classloader i carrego ConstructOnce altre cop");
	SimpleClassLoader secondClassLoader 
	    = new SimpleClassLoader( "testclasses" );
	Class c2 = secondClassLoader.loadClass( "ConstructOnce" );

	System.out.println("Creo la primera instància de ConstructOnce");
	Object x = c1.newInstance();

	System.out.println("Intento crear la segona instància de ConstructOnce amb el mateix classloader i...");
	try {
	    Object y = c1.newInstance();
	    throw new RuntimeException("Test fails");
	} catch( IllegalStateException e ) { 	System.out.println("... fracaso");}

	System.out.println("Creo una instancia de ConstructOnce amb el segon classloader");
	Object z = c2.newInstance();
    }
}

