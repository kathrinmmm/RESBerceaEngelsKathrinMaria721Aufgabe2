package src.Repository;

import src.Modell.Charakter;

import java.util.ArrayList;
import java.util.List;

public class CharakterRepository implements IRepository<Charakter> {

    private final List<Charakter> characters = new ArrayList<Charakter>();
    private int currentId = 1;

    public void create(Charakter obj) {
        obj.setId(currentId++);
        characters.add(obj);
    }

    @Override
    public Charakter read(int id) {
        for (Charakter character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    @Override
    public void update(Charakter obj) {
        Charakter character = read(obj.getId());
        if (character != null) {
            character.setName(obj.getName());
            character.setRegion(obj.getRegion());
            character.setProdukts(obj.getProdukts());
        }
    }

    @Override
    public void delete(int id) {
        characters.removeIf(character -> character.getId() == id);
    }

    @Override
    public List<Charakter> getAll() {
        return characters;
    }
}
