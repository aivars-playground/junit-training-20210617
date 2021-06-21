package training.junit.calendar;

import java.util.Objects;

public class CalendarEntry {

    private final String description;

    public CalendarEntry(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEntry that = (CalendarEntry) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

}
