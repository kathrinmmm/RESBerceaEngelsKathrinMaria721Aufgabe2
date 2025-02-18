package src.Repository;

import java.util.ArrayList;
import java.util.List;

public class CharakterRepository implements IRepository<Character> {

    private final List<Character> characters = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void create(Character obj) {
        obj.setId(currentId++);
        characters.add(obj);
    }

    @Override
    public Character read(int id) {
        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    @Override
    public void update(Character obj) {
        Character character = read(obj.getId());
        if (character != null) {
            character.setName(obj.getName());
            character.setRegion(obj.getRegion());
            character.setProducts(obj.getProducts());
        }
    }

    @Override
    public void delete(int id) {
        characters.removeIf(character -> character.getId() == id);
    }

    @Override
    public List<Character> getAll() {
        return characters;
    }
}
