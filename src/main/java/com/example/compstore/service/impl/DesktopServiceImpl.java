package com.example.compstore.service.impl;

import com.example.compstore.model.Desktop;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;
import com.example.compstore.repository.DesktopRepository;
import com.example.compstore.repository.ShoppingCartRepository;
import com.example.compstore.service.DesktopService;
import com.example.compstore.service.DesktopUpdateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesktopServiceImpl implements DesktopService {
    private final DesktopRepository desktopRepository;
    private final DesktopUpdateService desktopUpdateService;
    private final ShoppingCartRepository shoppingCartRepository;

    public DesktopServiceImpl(DesktopRepository desktopRepository,
                              DesktopUpdateService desktopUpdateService,
                              ShoppingCartRepository shoppingCartRepository) {
        this.desktopRepository = desktopRepository;
        this.desktopUpdateService = desktopUpdateService;
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public Desktop create(Desktop desktop) {
        return desktopRepository.save(desktop);
    }

    @Override
    public Desktop get(Long desktopId) {
        return desktopRepository.findById(desktopId).orElseThrow(
                () -> new RuntimeException("Can't find desktop by id: " + desktopId)
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
        desktopToDelete.setDeleted(true);
        return create(desktopToDelete);
    }

    @Override
    public ShoppingCart buy(User user, Desktop desktop) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
        shoppingCart.getItems().add(desktop);
        return shoppingCartRepository.save(shoppingCart);
    }
}
