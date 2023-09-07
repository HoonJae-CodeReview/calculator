package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.main.Recorder;

public class RecorderTest {

    private Recorder recorder;

    @BeforeEach
    void resetRecorder(){
        recorder = new Recorder();
    }

    @Test
    @DisplayName("이전에 계산했던 계산식인지 판단할 수 있다.")
    void testIsAlreadyCalculated() {

        // given
        recorder.addHistory("1 + 1",2);
        boolean expected = true;

        // when
        boolean isAlreadyCalculated = recorder.isAlreadyCalculated("1 + 1");

        // then
        Assertions.assertEquals(expected, isAlreadyCalculated);
    }

    @Test
    @DisplayName("중복된 계산식을 저장하지 않는다.")
    void testRecordDuplicated() {

        // given
        recorder.addHistory("1 + 1",2);
        recorder.addHistory("1 + 1",2);
        recorder.addHistory("1 + 1",2);
        String expected = "1 + 1 = 2\n";

        // when
        String history = recorder.getHistory();

        // then
        Assertions.assertEquals(expected, history);
    }

    @Test
    @DisplayName("계산식을 계산한 순서에 맞게 저장한다.")
    void testRecordOrder() {

        // given
        recorder.addHistory("2 + 1",3);
        recorder.addHistory("1 + 1",2);
        recorder.addHistory("3 + 1",4);
        String expected = "2 + 1 = 3\n1 + 1 = 2\n3 + 1 = 4\n";

        // when
        String history = recorder.getHistory();

        // then
        Assertions.assertEquals(expected, history);
    }

}
