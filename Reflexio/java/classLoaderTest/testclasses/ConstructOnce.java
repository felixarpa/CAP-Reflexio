
public class ConstructOnce {
    static private boolean runOnce = false;
    public ConstructOnce() {
	if ( runOnce )
	    throw new IllegalStateException("run twice");
	runOnce = true;
    }
}

