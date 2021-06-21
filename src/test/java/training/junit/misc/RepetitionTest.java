package training.junit.misc;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepetitionTest {

    @RepeatedTest(2)
    void tryOverAndOverAgain(RepetitionInfo ri) {
        System.out.println("ri " + ri);
    }
}
