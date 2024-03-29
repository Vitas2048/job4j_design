package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ArgsNameTest {
    @Test
    void whenGetFirst() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        assertThat(jvm.get("Xmx")).isEqualTo("512");
    }

    @Test
    void whenGetFirstReorder() {
        ArgsName jvm = ArgsName.of(new String[] {"-encoding=UTF-8", "-Xmx=512"});
        assertThat(jvm.get("Xmx")).isEqualTo("512");
    }

    @Test
    void whenMultipleEqualsSymbol() {
        ArgsName jvm = ArgsName.of(new String[] {"-request=?msg=Exit="});
        assertThat(jvm.get("request")).isEqualTo("?msg=Exit=");
    }

    @Test
    void whenGetNotExist() {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512"});
        assertThatThrownBy(() -> jvm.get("Xms")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenWrongSomeArgument() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{}))
                .isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("Отсутствуют параметры");
    }

    @Test
    void whenNoKey() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"-=?msg=Exit="}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("нет ключа в строке:-=?msg=Exit=");
    }

    @Test
    void whenNoEqual() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"-Xmx:512"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("несоответствие шаблону: -ключ=значение в строке:-Xmx:512");
    }

    @Test
    void whenNoMinus() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"Xmx=512"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("несоответствие шаблону: -ключ=значение в строке:Xmx=512");
    }

    @Test
    void whenNoValue() {
        assertThatThrownBy(() -> ArgsName.of(new String[]{"-Xmx="}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("нет значения в строке:-Xmx=");
    }
}