package tasklist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void todoTest() {
        Todo t = new Todo("Read book");
        assertEquals("[T][ ] Read book", t.toString());

        t.markDone();
        assertEquals("[T][X] Read book",t.toString());

        t.unmarkDone();
        assertEquals("[T][ ] Read book",t.toString());
    }
}