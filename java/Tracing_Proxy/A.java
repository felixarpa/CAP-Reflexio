
 interface A {
    public String mA1( String s );
    public boolean mA2( boolean b );
 }

 interface B {
    public Object mB1( Object obj );
    public void mB2();
 }

 interface AB extends A, B {};

 class C implements AB {
    public String mA1( String s ) { return "set"; };
    public boolean mA2( boolean b ) { return !b; };
    public Object mB1( Object obj ) { return new Integer(7); };
    public void mB2() {};
 }

