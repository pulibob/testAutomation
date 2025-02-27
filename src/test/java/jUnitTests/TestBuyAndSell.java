package jUnitTests;

import org.junit.platform.commons.annotation.Testable;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestBuyAndSell{

//    @Autowired
//   public Utilty Utilty;

@Testable()
public Stream<String> buyfilled() {

    //call the data driven line here
    //validation actual message contains buy in the payload as a mock
   // String actualMessage = "buy";


  static Stream<String> provideTestCasesFromExcel() {
    return Stream.of("Testcase 1", "Testcase 2", "Testcase 3"); // Replace with Excel reader logic
    }

    /*@ParameterizedTest
    @MethodSource("src/main/resources/csv/test-data.xlsx")
    @DisplayName("Test JSON Retrieval with @MethodSource")
    void testJsonRetrievalFromMethod(String testCaseName) {
    String jsonData = Utilty.getJsonString(testCaseName);
    assertNotNull(jsonData);
    }
*/

}


}
