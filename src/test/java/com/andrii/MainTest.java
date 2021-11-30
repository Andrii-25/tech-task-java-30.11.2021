package com.andrii;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;


public class MainTest {

    private final Main main = new Main();

    @Test
    public void processing() {
        assertNotNull(main.processing(Main.getListWithRandomStrings(1000000), 2));
    }

    @Test
    public void processingWithZeroCapacity() {
        assertNotNull(main.processing(Main.getListWithRandomStrings(0), 2));
    }

    @Test
    public void processingWithZeroMaxDuplicates() {
        assertNotNull(main.processing(Main.getListWithRandomStrings(1000000), 0));
    }
}
