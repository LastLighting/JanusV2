package topprogersgroup.service;


public interface BaseService<T> {
    T create(T t);
    void delete(T t);
    T edit(T t);
}
