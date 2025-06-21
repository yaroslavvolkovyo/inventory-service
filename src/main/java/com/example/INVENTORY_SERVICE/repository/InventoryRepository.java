package com.example.INVENTORY_SERVICE.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.INVENTORY_SERVICE.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryItem, Long> {
    int productArticle(int article);

    @Query("SELECT i.quantity FROM InventoryItem i WHERE i.productArticle = ?1")
    Long findQuantityByProductArticle(Long productArticle);

}
