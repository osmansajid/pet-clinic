package com.example.petclinic.services.map;

import com.example.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>  {
    private Map<Long, T> map = new HashMap<>();

    public T findById(ID id) {
        return map.get(id);
    }

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T save(T o) {
        if(o != null){
            if(o.getId() == null){
               o.setId(getNextId());
            }
            map.put(o.getId(),o);
        }else{
            throw new RuntimeException("Object cannot be found");
        }

        return o;
    }

    public void delete(T o) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(o));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}

