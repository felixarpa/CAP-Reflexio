import java.lang.*;
import java.lang.reflect.*;
import java.io.*;

public class HelloWorldGenerator { 

    public static void main( String[] args ) {

	try { 

	    FileOutputStream fstream
		= new FileOutputStream( "HelloWorld.java" ); 
	    PrintWriter out = new PrintWriter( fstream ); 
	    out.println( "public class HelloWorld {	\n" 
		       + "	public static void main( String[] args ) {  \n"
		       + "           System.out.println( \"Hello World!\" ); \n"
		       + "       }  \n"
		       + "}  \n" );
	    out.flush();

	    Process p = Runtime.getRuntime().exec( "javac HelloWorld.java" );
	    p.waitFor();  // aquest programa es pot bloquejar aquí si el javac té algun error

	    if ( p.exitValue() == 0 ) { 
		Class outputClassObject = Class.forName( "HelloWorld" );
		Class[] fpl = { String[].class }; 
		Method m = (Method)outputClassObject.getDeclaredMethod( "main", fpl );
		m.invoke( null, new Object[]{ new String[] {} } );
	    } else { 
		InputStream errStream = p.getErrorStream(); 
		for ( int j = errStream.available(); j > 0; j-- )
		    System.out.write( errStream.read() );
	    } 
	} catch(Exception e){
	    throw new RuntimeException(e);
	}
    }
}
