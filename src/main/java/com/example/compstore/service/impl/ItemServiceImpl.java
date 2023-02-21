package com.example.compstore.service.impl;

import com.example.compstore.model.*;
import com.example.compstore.repository.ItemRepository;
import com.example.compstore.repository.ShoppingCartRepository;
import com.example.compstore.service.ItemService;
import com.example.compstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartRepository shoppingCartRepository;


    public ItemServiceImpl(ItemRepository itemRepository,
                           ShoppingCartService shoppingCartService,
                           ShoppingCartRepository shoppingCartRepository) {
        this.itemRepository = itemRepository;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item get(Long itemId) throws Throwable {
        return (Item) itemRepository.findById(itemId).orElseThrow(
                () -> new RuntimeException("Can't find laptop by id: " + itemId)
        );
    }

    @Override
    public Item create(Item item) {
        return (Item) itemRepository.save(item);
    }

    @Override
    public Item update(Long modelId, Item model) {
        return null;
    }

    @Override
    public Item delete(Long itemId) throws Throwable {
        Item itemToDelete = get(itemId);
        itemToDelete.setDeleted(true);
        return (Item) itemRepository.save(itemToDelete);
    }

    @Override
    public ShoppingCart addItemToShoppingCart(User user, Item item) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUser(user);
        shoppingCart.getItems().add(item);
        return shoppingCartRepository.save(shoppingCart);
    }

}
