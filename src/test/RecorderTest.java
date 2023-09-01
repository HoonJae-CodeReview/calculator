package src.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.main.Recorder;

public class RecorderTest {

    @Test
    @DisplayName("이전에 계산했던 계산식인지 판단할 수 있다.")
    void testIsAlreadyCalculated() {
        Recorder recorder = new Recorder();
        recorder.addHistory("1 + 1",2);

        boolean isAlreadyCalculated = recorder.isAlreadyCalculated("1 + 1");
        boolean expected = true;
        Assertions.assertEquals(expected, isAlreadyCalculated);
    }

    @Test
    @DisplayName("중복된 계산식을 저장하지 않는다.")
    void testRecordDuplicated() {
        Recorder recorder = new Recorder();
        recorder.addHistory("1 + 1",2);
        recorder.addHistory("1 + 1",2);
        recorder.addHistory("1 + 1",2);

        String history = recorder.getHistory();
        String expected = "1 + 1 = 2\n";
        Assertions.assertEquals(expected, history);
    }

    @Test
    @DisplayName("계산식을 계산한 순서에 맞게 저장한다.")
    void testRecordOrder() {
        Recorder recorder = new Recorder();
        recorder.addHistory("2 + 1",3);
        recorder.addHistory("1 + 1",2);
        recorder.addHistory("3 + 1",4);

        String history = recorder.getHistory();
        String expected = "2 + 1 = 3\n1 + 1 = 2\n3 + 1 = 4\n";
        Assertions.assertEquals(expected, history);
    }

}
