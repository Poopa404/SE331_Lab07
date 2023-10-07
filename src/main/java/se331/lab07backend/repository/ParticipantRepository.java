package se331.lab07backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.lab07backend.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
    List<Participant> findAll();

}
