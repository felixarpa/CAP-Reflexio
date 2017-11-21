import DCR.*;

public class Main {
    public static void main(String[] args) {

        try {
            Product[] p = new Product[5];
            
            AbstractProduct.reload("ProductA");
            for (int i=0; i < 5; i++) {
                p[i] = AbstractProduct.newInstance();
            }
            for (int i=0; i < 5; i++) {
                p[i].missatgeProducte();
            }
            System.out.println();
            
            AbstractProduct.reload("ProductB");
            for (int i=0; i < 5; i++) {
                System.out.print("   ");
                p[i].missatgeProducte();
            }
            System.out.println();
            
            AbstractProduct.reload("ProductC");
            for (int i=0; i < 5; i++) {
                System.out.print("      ");
                p[i].missatgeProducte();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

