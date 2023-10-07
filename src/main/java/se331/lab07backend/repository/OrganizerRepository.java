package se331.lab07backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.lab07backend.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer,Long> {
    List<Organizer> findAll();

}
