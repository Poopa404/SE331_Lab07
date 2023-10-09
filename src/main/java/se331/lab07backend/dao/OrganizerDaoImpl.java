package se331.lab07backend.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.lab07backend.entity.Organizer;
import se331.lab07backend.repository.OrganizerRepository;

@Repository
@RequiredArgsConstructor

public class OrganizerDaoImpl implements OrganizerDao {
    final OrganizerRepository organizerRepository;
    @Override
    public Page<Organizer> getOrganizer(Pageable pageRequest) {
        return organizerRepository.findAll(pageRequest);
    }
    @Override
    public Optional<Organizer> findById(Long id) {
        return organizerRepository.findById(id);
    }
    @Override
    public Organizer getOrganizer(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }
    @Override
    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
}
