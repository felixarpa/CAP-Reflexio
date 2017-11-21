import org.apache.commons.lang3.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
	
	for(int i=18; i < 25; ++i) {
	    double res = Memoizer.memoizedf((double)i);
	    System.out.println("memoizedf("+i+") = "+res);
	}
    }
}


