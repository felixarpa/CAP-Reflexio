public class Halt {
    public static void haltIf (String s) throws HaltIfException {
        StackTraceElement[] ste = (new Throwable()).getStackTrace();    

        for ( int i = 0; i < ste.length; i++ ) {
            if ( ste[i].getMethodName().equals(s) ) {
                throw  new HaltIfException("M'han cridat des del mètode equivocat!!");
            }
        }
    }
}

class HaltIfException extends Exception {
    public HaltIfException(String s) { super(s); }
}
