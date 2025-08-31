// Vijay Venkatesan

import java.util.HashMap;

public class VendingMachine {
    private HashMap<String, Product> inventory;
    private float total_money_collected;
    private int restock_amount;

    public VendingMachine(HashMap<String, Product> inventory, int restock_amount) {
        this.inventory = inventory;
        this.total_money_collected = 0;
        this.restock_amount = restock_amount;
    }

    public DispenseResult dispense_product(String product_name, float money_received) {
        if (isProductAvailable(product_name)) {
            float money_required = this.inventory.get(product_name).getPrice();
            if (isAmountSufficient(money_received, money_required)) {
                float change = computeChange(money_received, money_required);
                Product product = this.inventory.get(product_name);
                DispenseResult res = new DispenseResult(product, change);
                decrementProductQuantity(product_name, this.restock_amount);
                this.total_money_collected += money_required;
                return res;
            } else {
                System.out.println("Sorry, insufficient funds");
            }        
        } else {
            System.out.println("Sorry, product not available.");
        }
        return null;
    }

    public void restock(String product_name, int quantity) {
        if (!this.inventory.containsKey(product_name)) {
            System.out.println("Product does not exist in inventory");
        } else {
            Product product = this.inventory.get(product_name);
            product.setQuantity(product.getQuantity() + quantity);
        }
    }

    public float collect_money() {
        float money_collected = this.total_money_collected;
        this.total_money_collected = 0;
        return money_collected;
    }

    private boolean isProductAvailable(String product_name) {
        if (this.inventory.containsKey(product_name)) {
            Product product = this.inventory.get(product_name);
            return product.getQuantity() >= 1;
        } else {
            return false;
        }
    }

    private boolean isAmountSufficient(float money_received, float money_required) {
        return money_received >= money_required;
    }

    private float computeChange(float money_received, float money_required) {
        return money_received - money_required;
    }

    private void decrementProductQuantity(String product_name, int restock_amount) {
        if (!this.inventory.containsKey(product_name)) {
            System.out.println("Product not found in inventory.");
        } else if (this.inventory.get(product_name).getQuantity() < 1) {
            System.out.println("Product is out of stock.");
        } else {
            Product product = this.inventory.get(product_name);
            product.setQuantity(product.getQuantity() - 1);
            if (product.getQuantity() == 0) {
                restock(product_name, restock_amount);
            }
        }
    }
}