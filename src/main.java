package src;

import src.Controller.Controller;
import src.Modell.Charakter;
import src.Modell.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    static Scanner scanner = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n   - Menu -");
            System.out.println("1. Manage Products (CRUD)");
            System.out.println("2. Manage Charaktere (CRUD)");
            System.out.println("3. Filter produkte by universum");
            System.out.println("4. Sort Charaktere for a produkt by univers");
            System.out.println("5. Sort Products for a Charakter by Price");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> manageProducts();
                case 2 -> manageCharaktere();
                case 3 -> {
                    System.out.println("Enter universum: ");
                    String universum = scanner.nextLine();
                    controller.filterProduktByUniversum(universum);
                }
                case 4 -> {
                    System.out.print("Enter charakter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Sort order (asc/desc): ");
                    String order = scanner.nextLine();
                    controller.sortProduktsForCharakterByUnivers(id, order);
                }
                case 5 -> {
                    System.out.print("Enter customer ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Sort order (asc/desc): ");
                    String order = scanner.nextLine();
                    controller.sortProduktsForCharakterByPrice(id, order);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageProducts() {
        while (true) {
            System.out.println("\n  - Manage Products -");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    float price = Float.parseFloat(scanner.nextLine());
                    System.out.print("Enter product season: ");
                    String universum = scanner.nextLine();
                    Produkt newProdukt = new Produkt(name, price, universum);
                    controller.addProdukt(newProdukt);
                    System.out.println("Product added successfully.");
                }
                case 2 -> {
                    System.out.println("\n");
                    for (Produkt product : controller.getAllProdukts())
                        System.out.println(product.toString());
                }
                case 3 -> {
                    System.out.print("Enter produkt name to edit: ");
                    String name = scanner.nextLine();
                    int produkt = findProdutByName(name);
                    if (false) {
                        int id = produkt;
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new price: ");
                        float newPrice = Float.parseFloat(scanner.nextLine());
                        System.out.print("Enter new season: ");
                        String newUniversum = scanner.nextLine();
                        controller.updateProdukt(id, newName, newPrice, newUniversum);
                        System.out.println("Product updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter produkt name to delete: ");
                    String name = scanner.nextLine();
                    Produkt produkt = findProductByName(name);
                    if (produkt != null) {
                        int id = produkt.getId();
                        controller.deleteProdukt(id);
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static int findProdutByName(String name) {
        return 0;
    }

    private static Produkt findProductByName(String name) {
        for (Produkt produkt : controller.getAllProdukts()) {
            if (produkt.getName().equalsIgnoreCase(name)) {
                return produkt;
            }
        }
        return null;
    }

    private static void manageCharaktere() {
        while (true) {
            System.out.println("\n  - Manage Charakters -");
            System.out.println("1. Add Charakter");
            System.out.println("2. View All harakters");
            System.out.println("3. Edit Charakters");
            System.out.println("4. Delete charakters");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter harakters name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter harakters region: ");
                    String location = scanner.nextLine();
                    List<Produkt> charakterProdukts = new ArrayList<>();
                    Charakter newCharakter = new Charakter(name, location, charakterProdukts);
                    controller.addCharakter(newCharakter);
                    System.out.println("Charakter added successfully.");
                }
                case 2 -> {
                    System.out.println("\n");
                    for (Charakter charakter : controller.getAllCharaktere())
                        System.out.println(charakter.toString());
                }
                case 3 -> {
                    System.out.print("Enter charakters ID to edit: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Charakter charakter = controller.getCharakter(id);
                    if (charakter != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new region: ");
                        String newRegion = scanner.nextLine();
                        for (Produkt produkt : controller.getAllProdukts())
                            System.out.println(produkt.toString());
                        System.out.print("Choose product by id: ");
                        int productId = Integer.parseInt(scanner.nextLine());
                        controller.updateCharakter(id, newName, newRegion, productId);
                        System.out.println("Customer updated successfully.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter charakter ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Charakter charakter = controller.getCharakter(id);
                    if (charakter != null) {
                        controller.deleteCharakter(id);
                        System.out.println("Charakters deleted successfully.");
                    } else {
                        System.out.println("Charaker not found.");
                    }
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}