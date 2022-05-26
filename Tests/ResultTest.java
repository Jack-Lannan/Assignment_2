import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    static Result r;
    static Result r2;

    @BeforeAll
    static void start(){
        r = new Result("test,98765,c0de,HD");
        r2 = new Result("test,345678,c0%e,*C,55");
    }

    @Test
    @DisplayName("write")
    void write() {
        assertAll(
                () -> assertEquals("c0de HD\n",r.write()),
                () -> assertEquals("c0%e *C 55\n",r2.write())
        );

    }

    @Test
    void getCode() {
        assertAll(
                () -> assertEquals("c0de",r.getCode()),
                () -> assertEquals("c0%e",r2.getCode())
        );
    }

    @Test
    void getGrade() {
        assertAll(
                () -> assertEquals("HD",r.getGrade()),
                () -> assertEquals("*C",r2.getGrade())
        );
    }

    @Test
    void getMark() {
        assertAll(
                () -> assertEquals(-1,r.getMark()),
                () -> assertEquals(55,r2.getMark())
        );
    }
}