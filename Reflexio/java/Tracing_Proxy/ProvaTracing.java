
 import java.lang.reflect.*;
 import java.io.PrintWriter;

 public class ProvaTracing {
    public static void main(String args[])
    {
	
	A aa = (A)TracingIH.createProxy( new C(), 
					 new PrintWriter(System.out) ); 

	String sA  = aa.mA1("siete");
	boolean bA = aa.mA2(true);
        Object oA = ((B)aa).mB1(new Boolean(true) );
	((B)aa).mB2();
	
	B bb = (B)TracingIH.createProxy( new C(), 
					 new PrintWriter(System.out) ); 

	String sB  = ((A)bb).mA1("siete");
        boolean bB = ((A)bb).mA2(true);
	Object oB =  bb.mB1(new Boolean(true) );
	bb.mB2();

	AB oo = (AB)TracingIH.createProxy( new C(), 
					 new PrintWriter(System.out) );

	String sO  = oo.mA1("siete");
	boolean bO = oo.mA2(true);
	Object oO =  oo.mB1(new Boolean(true) );
        oo.mB2();
    }
 }




