/*
 * Copyright 2021-2021 MrCool.
 *
 */

package com.mrcool.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class name.
 *
 * @author Mahendra Gadila.
 * @since 1.0.0
 */
class MyStreamsTest {

    @Test
    void test(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Ann");
        names.add("Barry");
        names.add("Cixin");
        names.add("Dante");

        names.stream().forEach(System.out::println);
        assertThat(names.stream().count()).isEqualTo(4);
    }



}
