package com.example.compstore.service;

import java.util.List;

public interface GenericService<M> {
    M create(M model);
    M get(Long modelId);
    List<M> getAll();
    M update(Long modelId, M model);
    M delete(Long modelId);

}
