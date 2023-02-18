package com.example.compstore.service.impl;

import com.example.compstore.model.AllInOne;
import com.example.compstore.repository.AllInOneRepository;
import com.example.compstore.service.AllInOneService;
import com.example.compstore.service.AllInOneUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllInOneServiceImpl implements AllInOneService {
    private final AllInOneRepository allInOneRepository;
    private final AllInOneUpdateService allInOneUpdateService;

    public AllInOneServiceImpl(AllInOneRepository allInOneRepository,
                               AllInOneUpdateService allInOneUpdateService) {
        this.allInOneRepository = allInOneRepository;
        this.allInOneUpdateService = allInOneUpdateService;
    }


    @Override
    public AllInOne create(AllInOne allInOne) {
        return allInOneRepository.save(allInOne);
    }

    @Override
    public AllInOne get(Long allInOneId) {
        return allInOneRepository.findById(allInOneId).orElseThrow(
                () -> new RuntimeException("Can't find laptop by id: " + allInOneId)
        );
    }

    @Override
    public List<AllInOne> getAll() {
        return allInOneRepository.findAll();
    }

    @Override
    public AllInOne update(Long allInOneId, AllInOne allInOne) {
        AllInOne allInOneToUpdate = get(allInOneId);
        allInOneUpdateService.updateModel(allInOne, allInOneToUpdate);
        return allInOneRepository.save(allInOneToUpdate);
    }

    @Override
    public AllInOne delete(Long allInOneId) {
        AllInOne allInOneToDelete = get(allInOneId);
        allInOneRepository.delete(allInOneToDelete);
        return allInOneToDelete;
    }
}
