package com.example.petclinic.services.map;

import com.example.petclinic.model.Owner;
import com.example.petclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
