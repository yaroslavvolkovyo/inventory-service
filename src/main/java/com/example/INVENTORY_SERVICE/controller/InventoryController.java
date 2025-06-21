package com.example.INVENTORY_SERVICE.controller;

import com.example.INVENTORY_SERVICE.entity.InventoryItem;
import com.example.INVENTORY_SERVICE.repository.InventoryRepository;
import com.example.INVENTORY_SERVICE.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{article}")
    public Long getQuantity(@PathVariable Long article) {
        return inventoryService.getQuantity(article);
    }

    @PostMapping
    public InventoryItem save(@RequestBody InventoryItem inventoryItem) {
        return inventoryService.save(inventoryItem);
    }

}
