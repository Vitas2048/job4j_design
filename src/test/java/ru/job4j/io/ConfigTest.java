package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/test.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name1")).isEqualTo("Vitaly");
    }

    @Test
    void whenPairWitComment() throws UnsupportedOperationException {

        String path = "./data/test.txt";
        Config config = new Config(path);
        config.load();
        UnsupportedOperationException thrown = assertThrows(
                UnsupportedOperationException.class,
                () -> config.value("name3"),
                "Don't impl this method yet!"
        );
        assertTrue(thrown.getMessage().contains("Don't impl this method yet!"));
        assertThat(config.value("name1")).isEqualTo("Vitaly");
        assertThat(config.value("name2")).isEqualTo("Alex");
    }
}