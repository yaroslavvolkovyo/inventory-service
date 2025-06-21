package com.example.INVENTORY_SERVICE.kafka;

import com.example.INVENTORY_SERVICE.eventDto.ProductCreatedEvent;
import com.example.INVENTORY_SERVICE.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryKafkaConsumer {
    private final InventoryService inventoryService;

    @KafkaListener(topics = "product.created", groupId = "inventory-group")
    public void handleProductCreated(ProductCreatedEvent event) {
        inventoryService.createInventory(event.getProductArticle(), event.getQuantity());
    }

}
