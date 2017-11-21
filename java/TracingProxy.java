import java.lang.reflect.*;
import java.io.PrintWriter;

public class TracingProxy {
    public static void main(String args[]) {
        A aa = (A) TracingIH.createProxy(
            new C(),
            new PrintWriter(System.out)
        );

        String sA = aa.mA1("Fèlix");
        boolean bA = aa.mA2(true);
        Object oA = ((B) aa).mB1(new Boolean(true));
        ((B) aa).mB2();

        B bb = (B) TracingIH.createProxy(
            new C(),
            new PrintWriter(System.out)
        );

        String sB = ((A) bb).mA1("Fèlix");
        boolean bB = ((A) bb).mA2(true);
        Object oB = bb.mB1(new Boolean(true));
        bb.mB2();

        AB ab = (AB) TracingIH.createProxy(
            new C(),
            new PrintWriter(System.out)
        );

        String sAB = ab.mA1("Fèlix");
        boolean bAB = ab.mA2(true);
        Object oAB = ab.mB1(new Boolean(true));
        ab.mB2();

        Method[] mProxy = TracingIH.createProxy(
            new C(),
            new PrintWriter(System.out)
        ).getClass().getMethods();

        for (int i = 0; i < mProxy.length ; ++i ) {
                System.out.println(mProxy[i].getName());   
        }
    }
}

interface A {
    public String mA1(String s);
    public boolean mA2(boolean b);
}

interface B {
    public Object mB1(Object obj);
    public void mB2();
    public void holaCarlotaCatot();
}

interface AB extends A, B {

}

class C implements AB {
    public String mA1(String s) {
        return " the cat ";
    }
    
    public boolean mA2(boolean b) {
        return !b;
    }

    public Object mB1(Object obj) {
        return new Integer(1);
    }
    
    public void mB2() {

    }

    public void holaCarlotaCatot() {

    }

}

class TracingIH implements InvocationHandler {
    
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

