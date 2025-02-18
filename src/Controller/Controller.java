package src.Controller;

import src.Modell.Charakter;
import src.Modell.Produkt;

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
        Product produkt = getProdukt(id);
        produkt.setName(name);
        produkt.setPrice(price);
        produkt.setSeason(universum);
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


    }

}
