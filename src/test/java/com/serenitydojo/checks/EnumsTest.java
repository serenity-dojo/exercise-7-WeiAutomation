package com.serenitydojo.checks;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumsTest {
    @Test
    public void theFoodTypeEnumShouldExist() throws ClassNotFoundException {
        assertThat(Class.forName("com.serenitydojo.FoodType")).isNotNull();
        assertThat(Class.forName("com.serenitydojo.FoodType").isEnum()).isNotNull();
    }

    @Test
    public void theFoodTypeEnumShouldHaveSomeValues() throws ClassNotFoundException {
        assertThat(Class.forName("com.serenitydojo.FoodType").getEnumConstants()).isNotEmpty();
    }

    @Test
    public void theFeedsMethodShouldReturnTheEnum() throws Exception {
        Method[] methods = Class.forName("com.serenitydojo.model.Feeder").getMethods();
        Method feedMethod = Arrays.stream(methods).filter(method -> method.getName().equals("feeds")).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No feeds() method found on the Feeder class"));
        assertThat(feedMethod.getParameterTypes()[0].getName()).isEqualTo("FoodType");
    }
}