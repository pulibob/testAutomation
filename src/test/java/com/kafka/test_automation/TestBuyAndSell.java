package com.kafka.test_automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;




public class TestBuyAndSell{


    private Utilty utilty;

    @BeforeEach
    void setUp() {
        utilty = new Utilty();
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesFromExcel")
    @DisplayName("Validate JSON Structure")
    void cryptoBuyMarketFilledInDollars(String testcase1) throws Exception {
        String result = utilty.getJsonString(testcase1);

        // Verify result is not empty
        assertNotNull(result);

    }

    static Stream<String> provideTestCasesFromExcel() {
        return Stream.of("Testcase 1"); // Replace with Excel reader logic
    }

}



