package se331.lab07backend.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.lab07backend.entity.Participant;
import se331.lab07backend.repository.ParticipantRepository;

@Repository
@RequiredArgsConstructor

public class ParticipantDaoImpl implements ParticipantDao {
    final ParticipantRepository participantRepository;
    @Override
    public Page<Participant> getParticipant(Pageable pageRequest) {
        return participantRepository.findAll(pageRequest);
    }
    @Override
    public Optional<Participant> findById(Long id) {
        return participantRepository.findById(id);
    }

}
