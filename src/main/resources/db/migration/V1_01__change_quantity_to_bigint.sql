ALTER TABLE inventory_item
    ALTER COLUMN quantity TYPE BIGINT USING quantity::BIGINT;