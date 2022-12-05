package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.LocalDateExpirationCalculator;
import ru.job4j.ood.lsp.productstorage.store.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {
    @Test
    public void whenCheckAllSores() throws ParseException {
        Food carrot = new Food("carrot", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(40), 120, 15);
        Food cucamber = new Food("cucamber", LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30), 100, 15);
        Food meat = new Food("meat", LocalDate.now().minusDays(9),
                LocalDate.now().plusDays(380), 100, 15);
        List<Food> exceptShop = new ArrayList<>();
        exceptShop.add(cucamber);
        List<Food> exceptWarehouse = new ArrayList<>();
        exceptWarehouse.add(meat);
        List<Food> exceptTrash = new ArrayList<>();
        exceptTrash.add(carrot);
        Trash trash = new Trash(new LocalDateExpirationCalculator());
        Shop shop = new Shop(new LocalDateExpirationCalculator());
        Warehouse warehouse = new Warehouse(new LocalDateExpirationCalculator());
        List<Store> stores = new ArrayList<>();
        stores.add(trash);
        stores.add(shop);
        stores.add(warehouse);
        FoodStore foodStore = new FoodStore();
        ControlQuality controlQuality = new ControlQuality(stores, foodStore);
        foodStore.add(carrot);
        foodStore.add(cucamber);
        foodStore.add(meat);
        controlQuality.execute();
        assertEquals(exceptTrash, trash.get());
        assertEquals(exceptShop, shop.get());
        assertEquals(exceptWarehouse, warehouse.get());
    }
}