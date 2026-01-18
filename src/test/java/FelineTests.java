import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTests {
    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    @DisplayName("feline.eatMeat() возвращает список питания для кошачьих")
    void eatMeatReturnsDietTest() throws Exception {
        List<String> expected = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("feline.getFamily() возвращает Кошачьи")
    void getFamilyReturnsFamilyNameTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Метод Feline.getKittens() возвращает кол-во котят, равное 1")
    void getKittensReturnsOneTest() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }
}
