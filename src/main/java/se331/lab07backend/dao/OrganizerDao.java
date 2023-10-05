package se331.lab07backend.dao;

import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;

import java.util.List;

public interface OrganizerDao {
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}
