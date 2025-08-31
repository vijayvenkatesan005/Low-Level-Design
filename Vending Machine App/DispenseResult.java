// Vijay Venkatesan

public class DispenseResult {
    private Product product;
    private float change;

    public DispenseResult(Product product, float change) {
        this.product = product;
        this.change = change;
    }

    public Product getProduct() {
        return this.product;
    }

    public float getChange() {
        return this.change;
    }
    
}
