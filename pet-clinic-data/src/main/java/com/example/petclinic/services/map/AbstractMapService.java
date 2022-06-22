package com.example.petclinic.services.map;

import com.example.petclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> implements CrudService<T,ID> {
    private Map<ID, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T save(ID id,T o) {
        map.put(id,o);
        return o;
    }

    @Override
    public void delete(T o) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(o));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}

