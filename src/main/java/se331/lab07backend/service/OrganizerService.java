package se331.lab07backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import se331.lab07backend.entity.Organizer;

public interface OrganizerService {
    List<Organizer> getAllOrganizer();
    Page<Organizer> getOrganizer(Integer page, Integer pageSize);
    Organizer getOrganizer(Long id);
    Organizer save(Organizer organizer);
}
