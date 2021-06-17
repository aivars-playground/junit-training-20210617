package training.calendar;

import java.util.ArrayList;
import java.util.List;

public class GlobalCalendar {

    private final List<CalendarEntry> entries;

    public GlobalCalendar() {
        entries = new ArrayList<>();
    }

    public List<CalendarEntry> getEntries() {
        return entries;
    }

    public void  addEntry(CalendarEntry entry) {
        entries.add(entry);
    }
}
