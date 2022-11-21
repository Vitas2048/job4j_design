package ru.job4j.template;

import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class TextGeneratorTest {

    @Test
    public void whenRightGenerate() {
        Generator generator = new TextGenerator();
        HashMap<String, String> mapGen = new HashMap<>();
        mapGen.put("name", "Petr Arsentev");
        mapGen.put("subject", "you");
        String input = "I am a ${name}, Who are ${subject}? ";
        String res = "I am a Petr Arsentev, Who are you? ";
        assertEquals(generator.produce(input, mapGen), res);
    }

    @Test
    public void whenWrongInputGenerate() {
        Generator generator = new TextGenerator();
        HashMap<String, String> mapGen = new HashMap<>();
        String input = "I am a ${mame}, Who are ${subjet}? ";
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(input, mapGen);
        });
    }

    @Test
    public void whenWrongMapGenerate() {
        Generator generator = new TextGenerator();
        HashMap<String, String> mapGen = new HashMap<>();
        mapGen.put("mame", "Petr Arsentev");
        mapGen.put("subjet", "you");
        String input = "I am a ${name}, Who are ${subject}? ";
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(input, mapGen);
        });
    }

    @Test
    public void whenExtraKeysGenerate() {
        Generator generator = new TextGenerator();
        HashMap<String, String> mapGen = new HashMap<>();
        mapGen.put("name", "Petr Arsentev");
        mapGen.put("subject", "you");
        assertThrows(IllegalArgumentException.class, () -> {
            mapGen.put("subject1", "you1");;
        });
}