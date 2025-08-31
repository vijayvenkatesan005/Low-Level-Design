// Vijay Venkatesan

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Product chips = new Product("Chips", 1.25f, 5);
        Product soda = new Product("Soda", 2.50f, 3);
        Product candy = new Product("Candy", 0.75f, 10);

        HashMap<String, Product> inventory = new HashMap<>();
        inventory.put(chips.getName(), chips);
        inventory.put(soda.getName(), soda);
        inventory.put(candy.getName(), candy);

        VendingMachine vm = new VendingMachine(inventory, 5);

        DispenseResult result1 = vm.dispense_product("Chips", 2.00f);

        if (result1 != null) {
            System.out.println("Dispensed: " + result1.getProduct().getName());
            System.out.println("Change returned: $" + result1.getChange());
        }

        DispenseResult result2 = vm.dispense_product("Soda", 1.00f);

        if (result2 != null) {
            System.out.println("Dispensed: " + result2.getProduct().getName());
            System.out.println("Change returned: $" + result2.getChange());
        }

        DispenseResult result3 = vm.dispense_product("Water", 1.00f);

        if (result3 != null) {
            System.out.println("Dispensed: " + result3.getProduct().getName());
            System.out.println("Change returned: $" + result3.getChange());
        }

        vm.restock("Soda", 2);

        System.out.println(soda.getQuantity());

        float cash = vm.collect_money();
        System.out.println("Total money collected: $" + cash);


    }
}
