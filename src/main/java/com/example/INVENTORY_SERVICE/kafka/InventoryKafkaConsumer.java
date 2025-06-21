package com.example.INVENTORY_SERVICE.kafka;

import com.example.INVENTORY_SERVICE.entity.InventoryItem;
import com.example.INVENTORY_SERVICE.eventDto.ProductCreatedEvent;
import com.example.INVENTORY_SERVICE.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InventoryKafkaConsumer {
    private final InventoryService inventoryService;


    @KafkaListener(topics = "product.created", groupId = "inventory-group")
    public void handleProductCreated(ProductCreatedEvent event) {
        log.info("Received Kafka event: {}", event); // Добавьте эту строку
        try {
            inventoryService.createInventory(event.getProductArticle(), event.getQuantity());
            log.info("Inventory created for article: {}", event.getProductArticle());
        } catch (Exception e) {
            log.error("Error creating inventory", e);
        }
    }

}
