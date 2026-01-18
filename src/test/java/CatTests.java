import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTests {
    private Cat cat;
    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("cat.getSound() возвращает Мяу")
    void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual, "Возвращает не тот голос");
    }

    @Test
    @DisplayName("cat.getFood() возвращает рацион питания")
    void getFoodTest() throws Exception {
        List<String> expected = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
    }
}
