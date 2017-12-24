public class HaltIfTest {
    public static void main (String[] args) {
        foo();
        System.out.println();
        bar();
    }

    static void foo () {
        System.out.println("crida a foo");
        try {
            Halt.haltIf("bar");
        } catch (HaltIfException e) {
            System.out.println("i ho han fet des de bar");
        }
    }

    static void bar () {
        System.out.println("crida a bar");
        foo();
    }
}

