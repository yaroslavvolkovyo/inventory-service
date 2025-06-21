package com.example.INVENTORY_SERVICE.service;

import com.example.INVENTORY_SERVICE.entity.InventoryItem;
import com.example.INVENTORY_SERVICE.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Long getQuantity(Long article) {
        return inventoryRepository.findQuantityByProductArticle(article);
    }

    public InventoryItem save(InventoryItem inventoryItem) {
        return inventoryRepository.save(inventoryItem);
    }
    public void createInventory(Long productArticle, int quantity) {
        InventoryItem item = new InventoryItem();
        item.setProductArticle(productArticle);
        item.setQuantity(quantity);
        inventoryRepository.save(item);
    }
}
