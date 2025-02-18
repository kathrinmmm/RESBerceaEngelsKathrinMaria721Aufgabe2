package src.Repository;

import java.util.ArrayList;
import java.util.List;

public class ProduktRepository implements IRepository<Produkt> {

    private final List<Produkt> produkts = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void create(Produkt obj) {
        obj.setId(currentId++);
        produkts.add(obj);
    }

    @Override
    public Produkt read(int id) {
        for (Produkt produkt : produkts) {
            if (produkt.getId() == id) {
                return produkt;
            }
        }
        return null;
    }

    @Override
    public void update(Produkt obj) {
        Produkt produkt = read(obj.getId());
        if (produkt != null) {
            produkt.setName(obj.getName());
            produkt.setPrice(obj.getPrice());
            produkt.setUniversum(obj.getUniversum());
        }
    }

    @Override
    public void delete(int id) {
        produkts.removeIf(produkt -> produkt.getId() == id);
    }

    @Override
    public List<Produkt> getAll() {
        return produkts;
    }

}
