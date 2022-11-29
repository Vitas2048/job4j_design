package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.Food;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {
    @Test
    public void moveToTrash() throws ParseException {
        AbstractStore store = new Trash();
        List<Food> except = new ArrayList<>();
        Food carrot = new Food("carrot", LocalDateTime.of(2022, 10, 20, 10, 10),
                LocalDateTime.of(2022, 11, 11, 10, 10), 120, 15);
        Food cucamber = new Food("cucamber", LocalDateTime.of(2022, 10, 20, 10, 10),
                LocalDateTime.of(2022, 12, 30, 10, 10), 100, 15);
        Food meat = new Food("meat", LocalDateTime.of(2022, 11, 20, 10, 10),
                LocalDateTime.of(2023, 12, 12, 10, 10), 100, 15);
        except.add(carrot);
        store.add(meat);
        store.add(carrot);
        store.add(cucamber);
        assertEquals(except, store.get());
    }
}