package com.example.springbook.util;


import com.example.springbook.modal.Product;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class CoreMatchers {

    public static <T> Matcher<T> with(Matcher<T> matcher) {
        return matcher;
    }

    public static Matcher<Product> named(String name) {
        return hasProperty("name", is(name));
    }
}
