import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTests {
    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    @DisplayName("lion.doesHaveMane() возвращает наличие гривы")
    void doesHaveManeTest(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("feline.getKittens(int kittensCount) возвращает нужное количество котят")
    void getKittensReturnsProvidedCount(int expected) {
        int actual = feline.getKittens(expected);
        assertEquals(expected, actual);
    }
}
