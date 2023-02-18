package com.example.compstore.service.impl;

import com.example.compstore.model.Desktop;
import com.example.compstore.model.Laptop;
import com.example.compstore.repository.DesktopRepository;
import com.example.compstore.service.DesktopService;
import com.example.compstore.service.DesktopUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesktopServiceImpl implements DesktopService {
    private final DesktopRepository desktopRepository;
    private final DesktopUpdateService desktopUpdateService;

    public DesktopServiceImpl(DesktopRepository desktopRepository,
                              DesktopUpdateService desktopUpdateService) {
        this.desktopRepository = desktopRepository;
        this.desktopUpdateService = desktopUpdateService;
    }


    @Override
    public Desktop create(Desktop desktop) {
        return desktopRepository.save(desktop);
    }

    @Override
    public Desktop get(Long desktopId) {
        return desktopRepository.findById(desktopId).orElseThrow(
                () -> new RuntimeException("Can't find laptop by id: " + desktopId)
        );
    }

    @Override
    public List<Desktop> getAll() {
        return desktopRepository.findAll();
    }

    @Override
    public Desktop update(Long desktopId, Desktop desktop) {
        Desktop desktopToUpdate = get(desktopId);
        desktopUpdateService.updateModel(desktop, desktopToUpdate);
        return desktopRepository.save(desktopToUpdate);
    }

    @Override
    public Desktop delete(Long desktopId) {
        Desktop desktopToDelete = get(desktopId);
        desktopRepository.delete(desktopToDelete);
        return desktopToDelete;
    }
}
