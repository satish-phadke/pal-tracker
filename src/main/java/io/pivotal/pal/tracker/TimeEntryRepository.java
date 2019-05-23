package io.pivotal.pal.tracker;

import java.util.List;

public interface  TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(Long timeEntryId);

    List<TimeEntry> list();

    void delete(Long timeEntryId);

    TimeEntry update(Long eq, TimeEntry any);
}
