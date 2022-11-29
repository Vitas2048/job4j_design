package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.store.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {
    @Test
    public void moveToTrash() throws ParseException {
        Food carrot = new Food("carrot", LocalDateTime.of(2022, 10, 20, 10, 10),
                LocalDateTime.of(2022, 11, 11, 10, 10), 120, 15);
        Food cucamber = new Food("cucamber", LocalDateTime.of(2022, 10, 20, 10, 10),
                LocalDateTime.of(2022, 12, 30, 10, 10), 100, 15);
        Food meat = new Food("meat", LocalDateTime.of(2022, 11, 20, 10, 10),
                LocalDateTime.of(2023, 12, 12, 10, 10), 100, 15);
        List<Food> exceptShop = new ArrayList<>();
        exceptShop.add(cucamber);
        List<Food> exceptWarehouse = new ArrayList<>();
        exceptWarehouse.add(meat);
        List<Food> exceptTrash = new ArrayList<>();
        exceptTrash.add(carrot);
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        List<Store> stores = new ArrayList<>();
        stores.add(trash);
        stores.add(shop);
        stores.add(warehouse);
        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.execute(carrot);
        controlQuality.execute(cucamber);
        controlQuality.execute(meat);
        assertEquals(exceptTrash, trash.get());
        assertEquals(exceptShop, shop.get());
        assertEquals(exceptWarehouse, warehouse.get());
    }
}