package src.Modell;

import java.util.List;

public class Charakter {

    private int id;
    private String name;
    private String region;
    private List<Produkt> produkts;

    public Character(String name, String region, List<Produkt> produkts) {
        this.name = name;
        this.region = region;
        this.produkts = produkts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Produkt> getProdukts() {
        return produkts;
    }

    public String getRegion() {
        return region;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setProdukts(List<Produkt> produkts) {
        this.produkts = produkts;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", produkts=" + produkts +
                '}';
    }
}
