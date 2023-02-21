package com.example.compstore.service.impl;

import com.example.compstore.model.AllInOne;
import com.example.compstore.model.Item;
import com.example.compstore.model.ShoppingCart;
import com.example.compstore.model.User;
import com.example.compstore.repository.AllInOneRepository;
import com.example.compstore.repository.ShoppingCartRepository;
import com.example.compstore.service.AllInOneService;
import com.example.compstore.service.AllInOneUpdateService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AllInOneServiceImpl implements AllInOneService {
    private final AllInOneRepository allInOneRepository;
    private final AllInOneUpdateService allInOneUpdateService;
    private final ShoppingCartRepository shoppingCartRepository;

    public AllInOneServiceImpl(AllInOneRepository allInOneRepository,
                               AllInOneUpdateService allInOneUpdateService,
                               ShoppingCartRepository shoppingCartRepository) {
        this.allInOneRepository = allInOneRepository;
        this.allInOneUpdateService = allInOneUpdateService;
        this.shoppingCartRepository = shoppingCartRepository;
    }


    @Override
    public AllInOne create(AllInOne allInOne) {
        return allInOneRepository.save(allInOne);
    }

    @Override
    public AllInOne get(Long allInOneId) {
        return allInOneRepository.findById(allInOneId).orElseThrow(
                () -> new RuntimeException("Can't find all-in-one by id: " + allInOneId)
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
        allInOneToDelete.setDeleted(true);
        return create(allInOneToDelete);
    }

    @Override
    public ShoppingCart buy(User user, AllInOne allInOne) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
        List<Item> items = shoppingCart.getItems();
        items.add(allInOne);
        shoppingCart.setItems(items);
        return shoppingCartRepository.save(shoppingCart);
    }
}
