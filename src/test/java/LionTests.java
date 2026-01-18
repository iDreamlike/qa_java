import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTests {
    private Lion lion;
    @Mock
    private Feline feline;

    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion(feline, "Самец");
    }

    @Test
    @DisplayName("lion.getKittens() возвращает 5")
    void getKittensTestReturnsFiveTest() {
        int expected = 5;
        Mockito.when(feline.getKittens()).thenReturn(5);
        int actual = lion.getKittens();
        assertEquals(expected, actual, "Возвращает неверное количество");
    }

    @Test
    @DisplayName("lion.getKittens() вызывает feline.getKittens() два раза")
    void getKittensCallsFelineGetKittensMethodTwiceTest() {
        lion.getKittens();
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(2)).getKittens();
    }

    @Test
    @DisplayName("Конструктор Lion(Feline feline, String sex) выбрасывает Exception при некорректных данных")
    void constructorLionSexThrowsExceptionTest() {
        Executable executable = () -> new Lion(feline, "Некорректные данные");
        assertThrows(Exception.class, executable, "Введены корректные данные, но ожидались некорректные");
    }

    @Test
    @DisplayName("lion.getFood() возвращает рацион хищника")
    void getFoodReturnsDietTest() throws Exception {
        List<String> expected = new ArrayList<>(List.of("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}
