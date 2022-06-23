package com.example.petclinic.services.map;

import com.example.petclinic.model.BaseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>  {
    private Map<Long, T> map = new HashMap<>();

    public T findById(ID id) {
        return map.get(id);
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T save(T o) {
        map.put(o.getId(),o);
        return o;
    }

    public void delete(T o) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(o));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }
}

