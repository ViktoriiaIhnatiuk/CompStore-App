package com.example.compstore.dto.response;

import com.example.compstore.model.Item;

import java.util.List;

public class ShoppingCartResponseDto {
        private Long id;
        private List<Item> items;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
}
