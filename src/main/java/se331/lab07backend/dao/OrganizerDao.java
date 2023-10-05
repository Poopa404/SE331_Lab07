package se331.lab07backend.dao;

import org.springframework.data.domain.Page;

import se331.lab07backend.entity.Organizer;


public interface OrganizerDao {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer event);

}
