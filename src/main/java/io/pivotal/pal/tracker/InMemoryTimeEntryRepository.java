package io.pivotal.pal.tracker;

import java.util.*;


public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private long idCounter = 0L;
    private Map<Long, TimeEntry> inMemoryTimeEntryById = new HashMap<Long, TimeEntry>();
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++idCounter);
        inMemoryTimeEntryById.put(idCounter, timeEntry);
        System.out.println("timeEntry## - "+timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return inMemoryTimeEntryById.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList(inMemoryTimeEntryById.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        inMemoryTimeEntryById.put(id,timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        inMemoryTimeEntryById.remove(id);
    }
}
