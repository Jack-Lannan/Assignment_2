import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    static StudentDatabase newStudent;

   @BeforeAll
    static void before(){
        newStudent = new StudentDatabase();
        newStudent.addStudent("M,9990099,Smith,John");
        newStudent.addStudent("M,9990199,Mary,Moo");
        newStudent.addResult("R,9990199,COMP1001,DN,77");
        newStudent.addResult("R,9990199,MEDD0119,HD,86");
        newStudent.addResult("R,9990099,COMP1001,HD,99");
        newStudent.addResult("R,9990199,MEDD0119,CR,75");
      ;

    }

    @Test
    void testPrize(){

        new Prize("P,ROH,MEDD,1").awardPrize(newStudent);
        newStudent.printRecords();



    }

    @Test
    void testawardPrize() {




        new Prize("P,ROH,MEDD,1").awardPrize(newStudent);
        newStudent.printRecords();

    }
}