package src.Repository;

import src.Modell.Charakter;

import java.util.List;

public interface IRepository<T> {

    void create(T obj);
    T read(int id);
    void update(Charakter obj);
    void delete(int id);
    List<T> getAll();

    void update(T produkt);
}
