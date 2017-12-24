
import java.lang.reflect.*;
import java.io.PrintWriter;

public class TracingIH implements InvocationHandler {
    
    public static Object createProxy( Object obj, PrintWriter out ) {
    	return Proxy.newProxyInstance( obj.getClass().getClassLoader(),
    	                               obj.getClass().getInterfaces(),
                                       new TracingIH( obj, out ) );
    }
    
    private Object target;
    private PrintWriter out;
    
    private TracingIH( Object obj, PrintWriter out ) { 
    	target = obj; 
    	this.out = out;
    }
    
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
    	Object result = null;
    	try {
                out.println( method.getName() + "(...) called" ); out.flush();
    	    result = method.invoke( target, args );
    	} catch (InvocationTargetException e) {
    	    out.println( method.getName() + " throws " + e.getCause() ); out.flush();
    	    throw e.getCause();
    	}
    	out.println( method.getName() + " returns: " + result.toString() ); out.flush();
    	return result;
    }
}

