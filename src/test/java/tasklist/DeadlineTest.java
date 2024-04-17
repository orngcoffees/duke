package tasklist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {

    @Test
    public void deadlineTest() {
        Deadline d = new Deadline("return book","Dec 12 2019 06:00");
        assertEquals("[D][ ] return book (by: Dec 12 2019 06:00)", d.toString());

        d.markDone();
        assertEquals("[D][X] return book (by: Dec 12 2019 06:00)",d.toString());

        d.unmarkDone();
        assertEquals("[D][ ] return book (by: Dec 12 2019 06:00)",d.toString());

        assertEquals("D | 0 | return book | Dec 12 2019 06:00",d.getTaskStorageString());

    }
}