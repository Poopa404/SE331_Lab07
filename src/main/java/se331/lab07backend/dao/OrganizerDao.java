package se331.lab07backend.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.lab07backend.entity.Organizer;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);
    Optional<Organizer> findById(Long id);
    Organizer save(Organizer organizer);
    Organizer getOrganizer(Long id);
}
