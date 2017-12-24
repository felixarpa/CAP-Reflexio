import DCR.*;

public class ProductImpl extends AbstractProduct {
    public void missatgeProducte() {
        System.out.println("Soc el producte C");
    }
    public static Product evolve (Object obj){
        ProductImpl pnew = new ProductImpl();
        return pnew;
    }
}
