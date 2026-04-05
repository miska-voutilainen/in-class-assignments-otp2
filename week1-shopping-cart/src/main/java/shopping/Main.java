package shopping;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");

        System.out.println("Select language / Valitse kieli / Välj språk / 言語を選択:");
        System.out.println("1. English");
        System.out.println("2. Finnish (Suomi)");
        System.out.println("3. Swedish (Svenska)");
        System.out.println("4. Japanese");
        System.out.print("> ");

        int langChoice = 1;
        try {
            langChoice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            langChoice = 1;
        }

        Locale locale;
        switch (langChoice) {
            case 2:
                locale = Locale.of("fi", "FI");
                break;
            case 3:
                locale = Locale.of("sv", "SE");
                break;
            case 4:
                locale = Locale.JAPAN;
                break;
            default:
                locale = Locale.US;
        }

        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.print(bundle.getString("items.prompt") + " ");
        int numItems = 0;
        try {
            numItems = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, defaulting to 1.");
            numItems = 1;
        }

        CartCalculator calc = new CartCalculator();

        for (int i = 1; i <= numItems; i++) {
            System.out.print(bundle.getString("price.prompt") + " " + i + ": ");
            double price = Double.parseDouble(sc.nextLine().trim());

            System.out.print(bundle.getString("qty.prompt") + " " + i + ": ");
            int qty = Integer.parseInt(sc.nextLine().trim());

            double itemTotal = calc.getItemCost(price, qty);
            calc.addItem(price, qty);
            System.out.println("  -> " + itemTotal);
        }

        double total = calc.getTotal();
        System.out.println(bundle.getString("total.label") + " " + String.format("%.2f", total));

        sc.close();
    }
}
