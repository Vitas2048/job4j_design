package ru.job4j.ood.lsp.productstorage.store;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.Food;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.LocalDateExpirationCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    public void moveToWarehouse() throws ParseException {
        AbstractStore store = new Warehouse(new LocalDateExpirationCalculator());
        List<Food> except = new ArrayList<>();
        Food carrot = new Food("carrot", LocalDateTime.now().minusDays(100),
                LocalDateTime.now().minusDays(40), 120, 15);
        Food cucamber = new Food("cucamber", LocalDateTime.now().minusDays(20),
                LocalDateTime.now().plusDays(30), 100, 15);
        Food meat = new Food("meat", LocalDateTime.now().minusDays(9),
                LocalDateTime.now().plusDays(380), 100, 15);
        except.add(meat);
        store.add(meat);
        store.add(carrot);
        store.add(cucamber);
        assertEquals(except, store.get());
    }

}