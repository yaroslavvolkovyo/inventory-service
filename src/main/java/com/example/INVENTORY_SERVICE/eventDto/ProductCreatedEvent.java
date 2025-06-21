package com.example.INVENTORY_SERVICE.eventDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreatedEvent {
    private String productId;
    private String title;
    private Long productArticle;
    private int quantity;
}
