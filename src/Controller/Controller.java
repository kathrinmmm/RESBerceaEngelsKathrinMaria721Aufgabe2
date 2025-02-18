package src.Controller;

import src.Modell.Charakter;
import src.Modell.Produkt;
import src.Repository.CharakterRepository;
import src.Repository.IRepository;
import src.Repository.ProduktRepository;

import java.util.Comparator;
import java.util.List;


public class Controller {

    private final IRepository<Produkt> produktIRepository;
    private final CharakterRepository charakterIRepository;

    public Controller() {
        this.produktIRepository = new ProduktRepository() {
            @Override
            public void update(Produkt produkt) {

            }
        };
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
    /**
     * Aktualisiert die Eigenschaften eines Charakters mit der angegebenen ID.
     *
     * @param id        Die eindeutige Identifikationsnummer des Charakters.
     * @param name      Der neue Name des Charakters.
     * @param region    Die neue Region des Charakters.
     * @param produktId Die ID des Produkts, das dem Charakter hinzugefügt werden soll.
     */
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

    /**
     * Sortiert die Produkts eines Charakters nach ihrem Namen in aufsteigender oder absteigender Reihenfolge.
     *
     * @param produktId Die ID des Charakters, dessen Produkts sortiert werden sollen.
     * @param order     Die Sortierreihenfolge: "asc" für aufsteigend, "desc" für absteigend.
     */
    public void sortProduktsForCharakterByUnivers(int produktId, String order) {
        Charakter charakter = getCharakter(produktId);
        if (order.equalsIgnoreCase("asc")) {
            List<Produkt> charakterProdukts = charakter.getProdukts();
            charakterProdukts.sort(Comparator.comparing(Produkt::getName));
            System.out.println("Produkts sorted by Univers (ascending):");
            for (Produkt produkt1 : charakterProdukts) {
                System.out.println(produkt1.toString());
            }
        } else if (order.equalsIgnoreCase("desc")) {
            List<Produkt> customerProdukts = charakter.getProdukts();
            customerProdukts.sort(Comparator.comparing(Produkt::getName).reversed());
            System.out.println("Produkts sorted by name (descending):");
            for (Produkt produkt1 : customerProdukts) {
                System.out.println(produkt1.toString());
            }
        } else {
            System.out.println("Typo.. please try again");
        }
    }

    public void sortProduktsForCharakterByPrice(int charakterId, String order) {
        Charakter charakter = getCharakter(charakterId);
        if (order.equalsIgnoreCase("asc")) {
            List<Produkt> customerProdukts = charakter.getProdukts();
            customerProdukts.sort(Comparator.comparingDouble(Produkt::getPrice));
            System.out.println("Produkts sorted by price (ascending):");
            for (Produkt produkt1 : customerProdukts) {
                System.out.println(order.toString());
            }
        } else if (order.equalsIgnoreCase("desc")) {
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

    public void updateProdukt(int id, String newName, float newPrice, String newUniversum) {
        Produkt produkt = getProdukt(id);
    }

    public Charakter[] getAllCharaktere() {

        return null;
    }
}
