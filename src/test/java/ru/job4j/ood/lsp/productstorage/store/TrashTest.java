package ru.job4j.ood.lsp.productstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.Food;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrashTest {
    @Test
    public void moveToTrash() throws ParseException {
        AbstractStore store = new Trash();
        List<Food> except = new ArrayList<>();
        Food carrot = new Food("carrot", new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2022"),
                new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2022"), 120, 15);
        Food cucamber = new Food("cucamber", new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2022"),
                new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2022"), 100, 15);
        Food meat = new Food("meat", new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2022"),
                new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2023"), 100, 15);
        except.add(carrot);
        store.store(meat);
        store.store(carrot);
        store.store(cucamber);
        assertEquals(except, store.get());
    }
}