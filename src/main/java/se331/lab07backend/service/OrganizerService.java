package se331.lab07backend.service;

import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}
