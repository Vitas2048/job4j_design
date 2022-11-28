package ru.job4j.ood.lsp.productstorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.productstorage.store.AbstractStore;
import ru.job4j.ood.lsp.productstorage.store.Shop;
import ru.job4j.ood.lsp.productstorage.store.Trash;
import ru.job4j.ood.lsp.productstorage.store.Warehouse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlQualityTest {
    @Test
    public void moveToTrash() throws ParseException {
        List<Food> except = new ArrayList<>();
        Food carrot = new Food("carrot", new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2022"),
                new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2022"), 120, 15);
        Food cucamber = new Food("cucamber", new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2022"),
                new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2022"), 100, 15);
        Food meat = new Food("meat", new SimpleDateFormat("dd/MM/yyyy").parse("20/11/2022"),
                new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2023"), 100, 15);
        except.add(carrot);
        except.add(cucamber);
        except.add(meat);
        List<Food> exceptShop = new ArrayList<>();
        exceptShop.add(cucamber);
        List<Food> exceptWarehouse = new ArrayList<>();
        exceptWarehouse.add(meat);
        List<Food> exceptTrash = new ArrayList<>();
        exceptTrash.add(carrot);
        ControlQuality controlQuality = new ControlQuality(except);
        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        controlQuality.execute(trash);
        controlQuality.execute(shop);
        controlQuality.execute(warehouse);
        assertEquals(exceptTrash, trash.get());
        assertEquals(exceptShop, shop.get());
        assertEquals(exceptWarehouse, warehouse.get());
    }
}