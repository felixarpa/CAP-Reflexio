package DCR;

import java.util.*;
import java.lang.reflect.*;
import java.lang.ref.*;

abstract public class AbstractProduct implements Product {
    
    static private ClassLoader cl = null;
    static private String      directory = null;
    static private Class       implClass;
    static private List<WeakReference> instances = new ArrayList<WeakReference>();
    
    public static Product newInstance( )
	throws InstantiationException, IllegalAccessException 
    {
	AbstractProduct obj = (AbstractProduct)implClass.newInstance();
	Product anAProxy = ProductIH.newInstance( obj );
	instances.add( new WeakReference<Product>( anAProxy ) );
	return anAProxy;
    }
	
    public static void reload( String dir ) 
	throws ClassNotFoundException, 
	       InstantiationException, 
	       IllegalAccessException,
	       NoSuchMethodException, 
	       InvocationTargetException 
    {
	cl = new SimpleClassLoader( dir );                        
	implClass = cl.loadClass( "ProductImpl" );                

	if (directory == null) { // first implementation          
	    directory = dir;                                      
	    return;                                               
	}

	directory = dir;
        List<WeakReference> newInstances = new ArrayList<WeakReference>();

	Method evolve 
	    = implClass.getDeclaredMethod( "evolve", 
					   new Class[]{Object.class} );

	for ( int i = 0; i < instances.size(); i++ ) {                    
	    Proxy x =(Proxy)(instances.get(i)).get();      
	    if ( x != null ) {                                            
		ProductIH aih = (ProductIH)Proxy.getInvocationHandler(x); 
		Product oldObject = aih.getTarget();                      
		Product replacement                                       
		    = (Product)evolve.invoke( null,                       
					       new Object[]{oldObject} );
		aih.setTarget( replacement );                            
		newInstances.add( new WeakReference<Proxy>( x ) );              
	    }
	}
	instances = newInstances;                                        
    }
}

