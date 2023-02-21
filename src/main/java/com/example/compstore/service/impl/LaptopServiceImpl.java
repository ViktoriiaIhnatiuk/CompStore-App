package com.example.compstore.service.impl;

import com.example.compstore.model.Item;
import com.example.compstore.model.Laptop;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;
import com.example.compstore.repository.LaptopRepository;
import com.example.compstore.repository.ShoppingCartRepository;
import com.example.compstore.service.LaptopService;
import com.example.compstore.service.LaptopUpdateService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final LaptopUpdateService laptopUpdateService;
    private final ShoppingCartRepository shoppingCartRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository,
                             LaptopUpdateService laptopUpdateService,
                             ShoppingCartRepository shoppingCartRepository) {
        this.laptopRepository = laptopRepository;
        this.laptopUpdateService = laptopUpdateService;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public Laptop create(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop get(Long laptopId) {
        return laptopRepository.findById(laptopId).orElseThrow(
                () -> new RuntimeException("Can't find laptop by id: " + laptopId)
        );
    }

    @Override
    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop update(Long laptopId, Laptop laptop) {
        Laptop laptopToUpdate = get(laptopId);
        laptopUpdateService.updateModel(laptop, laptopToUpdate);
        return laptopRepository.save(laptopToUpdate);
    }

    @Override
    public Laptop delete(Long laptopId) {
        Laptop laptopToDelete = get(laptopId);
        laptopToDelete.setDeleted(true);
        return create(laptopToDelete);
    }

    @Override
    public ShoppingCart buy(User user, Laptop laptop) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
        List<Item> items = shoppingCart.getItems();
        items.add(laptop);
        shoppingCart.setItems(items);
        return shoppingCartRepository.save(shoppingCart);
    }
}
