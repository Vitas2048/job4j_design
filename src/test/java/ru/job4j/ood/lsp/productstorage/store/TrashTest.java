package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.Food;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.LocalDateExpirationCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {
    @Test
    public void whenMoveToTrash() throws ParseException {
        AbstractStore store = new Trash(new LocalDateExpirationCalculator());
        List<Food> except = new ArrayList<>();
        Food carrot = new Food("carrot", LocalDate.now().minusDays(100),
                LocalDate.now().minusDays(40), 120, 15);
        Food cucamber = new Food("cucamber", LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30), 100, 15);
        Food meat = new Food("meat", LocalDate.now().minusDays(9),
                LocalDate.now().plusDays(380), 100, 15);
        except.add(carrot);
        store.add(meat);
        store.add(carrot);
        store.add(cucamber);
        assertEquals(except, store.get());
    }
}