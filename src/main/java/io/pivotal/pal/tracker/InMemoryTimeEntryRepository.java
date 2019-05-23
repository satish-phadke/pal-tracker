package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository {

    HashMap<Long, TimeEntry> map = new HashMap<Long, TimeEntry>();
    Long counter=0L;

    private Long currentId=1L;

    public TimeEntry create(TimeEntry timeEntry)  {
      //  long id;

        Long id = currentId++;
     //   id = generateID();
        TimeEntry ltimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());

        map.put(id,ltimeEntry);
        return ltimeEntry;
    }


    public TimeEntry find(Long id)  {
        TimeEntry timeEntry = new TimeEntry();
        for(Map.Entry<Long, TimeEntry> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
            if ( id == entry.getKey())
            return entry.getValue();
        }
        return null;
    }


    public List<TimeEntry> list()  {
        return new ArrayList<TimeEntry>(map.values());

       /* tList.addAll( map.values());
        /*for(Map.Entry<Long, TimeEntry> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
            tList.add(entry.getValue());
        }
*/
        //return tList;
    }


    public TimeEntry update(Long id, TimeEntry timeEntry)  {

        if (find(id) == null) return null;

        TimeEntry updatedEntry = new TimeEntry(
                id,
                timeEntry.getProjectId(),
                timeEntry.getUserId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        map.replace(id, updatedEntry);
        return updatedEntry;
    }


    public void delete(Long id) {

        map.remove(id);
    }
 }
