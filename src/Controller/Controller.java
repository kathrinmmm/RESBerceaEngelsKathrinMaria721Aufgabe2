package src.Controller;

import src.Modell.Charakter;
import src.Modell.Produkt;
import src.Repository.IRepository;

import java.util.Comparator;
import java.util.List;


public class Controller {

    private final IRepository<Produkt> produktIRepository;
    private final IRepository<Charakter> charakterIRepository;

    public Controller() {
        this.produktIRepository = new ProduktRepository();
        this.charakterIRepository = new CharakterRepository();
    }

    public Produkt getProdukt(int id) {
        return produktIRepository.read(id);
    }

    public Charakter getCharakter(int id) {
        return charakterIRepository.read(id);
    }

    public void addProdukt(Produkt produkt) {
        produktIRepository.create(produkt);
    }

    public void addCharakter(Charakter charakter) {
        charakterIRepository.create(charakter);
    }

    public void updateProduct(int id, String name, float price, String universum) {
        Produkt produkt = getProdukt(id);
        produkt.setName(name);
        produkt.setPrice(price);
        produkt.setUniversum(universum);
        produktIRepository.update(produkt);
    }

    public void updateCharakter(int id, String name, String region, int produktId) {
        Charakter charaktercharakter = getCharakter(id);
        charaktercharakter.setName(name);
        charaktercharakter.setRegion(region);
        List<Produkt> updatedProdukts = charaktercharakter.getProdukts();
        Produkt newProdukt = produktIRepository.read(produktId);
        updatedProdukts.add(newProdukt);
        charaktercharakter.setProdukts(updatedProdukts);
        charakterIRepository.update(charaktercharakter);
    }

    public void deleteProdukt(int id) {
        produktIRepository.delete(id);
    }

    public void deleteCharakter(int id) {
        charakterIRepository.delete(id);
    }

    public List<Produkt> getAllProdukts() {
        return produktIRepository.getAll();
    }

    public List<Charakter> getAllCharakters() {
        return charakterIRepository.getAll();
    }

    public void filterProduktByUniversum(String universum) {
        for (Produkt produkt : getAllProdukts()) {
            if (Produkt.getuniversum().equalsIgnoreCase(universum))
                System.out.println(produkt);
        }
    }

//    public void findCustomersBySeason(String season) {
//        for (Customer customer : getAllCharakters()) {
//            List<Product> customerProducts = customer.getProducts();
//            for (Product product : customerProducts) {
//                if (product.getSeason().equalsIgnoreCase(season)) {
//                    System.out.println(customer);
//                }
//            }
//        }
//    }

    public void sortProduktsForCharakterByUnivers(int produktId, String produkt) {
        Charakter charakter = getCharakter(produktId);
        if (produkt.equalsIgnoreCase("asc")) {
            List<Produkt> charakterProdukts = charakter.getProdukts();
            charakterProdukts.sort(Comparator.comparing(Produkt::getName));
            System.out.println("Produkts sorted by Univers (ascending):");
            for (Produkt produkt1 : charakterProdukts) {
                System.out.println(produkt1.toString());
            }
        } else if (produkt.equalsIgnoreCase("desc")) {
            List<Produkt> customerProdukts = charakter.getProdukts();
            customerProdukts.sort(Comparator.comparing(Produkt::getName).reversed());
            System.out.println("Produkts sorted by name (descending):");
            for (Produkt produkt : customerProdukts) {
                System.out.println(produkt.toString());
            }
        } else {
            System.out.println("Typo.. please try again");
        }
    }

    public void sortProduktsForCharakterByPrice(int charakterId, String produkt) {
        Charakter charakter = getCharakter(charakterId);
        if (produkt.equalsIgnoreCase("asc")) {
            List<Produkt> customerProdukts = charakter.getProdukts();
            customerProdukts.sort(Comparator.comparingDouble(Produkt::getPrice));
            System.out.println("Produkts sorted by price (ascending):");
            for (Produkt produkt1 : customerProdukts) {
                System.out.println(produkt.toString());
            }
        } else if (produkt.equalsIgnoreCase("desc")) {
            List<Produkt> customerProdukts = charakter.getProdukts();
            customerProdukts.sort(Comparator.comparingDouble(Produkt::getPrice).reversed());
            System.out.println("Produkts sorted by price (descending):");
            for (Produkt product : customerProdukts) {
                System.out.println(product.toString());
            }
        } else {
            System.out.println("Typo.. please try again");
        }
    }
}
