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

    @Test
    void whenWrongPattern() {
        String path = "./data/test1.txt";
        Config config = new Config(path);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertTrue(thrown.getMessage().contains("Не соответствие шаблону - key=value"));
    }
    @Test
    void whenNoKey() throws IllegalArgumentException {
        String path = "./data/test2.txt";
        Config config = new Config(path);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertTrue(thrown.getMessage().contains("Не соответствие шаблону - key=value"));
    }

    @Test
    void whenNoValue() throws IllegalArgumentException {
        String path = "./data/test3.txt";
        Config config = new Config(path);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                config::load
        );
        assertTrue(thrown.getMessage().contains("Не соответствие шаблону - key=value"));
    }

}