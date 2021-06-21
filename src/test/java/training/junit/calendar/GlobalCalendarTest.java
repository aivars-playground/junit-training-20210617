package training.junit.calendar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GlobalCalendarTest {

    @Test
    void addEntry() {
        var calendar = new GlobalCalendar();
        var entry = new CalendarEntry("All Day Event");

        calendar.addEntry(entry);

        var entries = calendar.getEntries();

        assertNotNull(entries);
        assertEquals(1, entries.size());
    }

    @Test
    void addEntry_multiple() {
        var calendar = new GlobalCalendar();
        var entry1 = new CalendarEntry("Event1");
        var entry2 = new CalendarEntry("Event2");

        calendar.addEntry(entry1);
        calendar.addEntry(entry2);

        var entries = calendar.getEntries();

        var expectedEntries = List.of(entry1,entry2);

        assertNotNull(entries);
        assertIterableEquals(expectedEntries,entries);//can be used on different collections
    }
}
