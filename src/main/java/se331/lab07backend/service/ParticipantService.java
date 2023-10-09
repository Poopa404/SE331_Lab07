package se331.lab07backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import se331.lab07backend.entity.Participant;

public interface ParticipantService {
    List<Participant> getAllParticipants();
    Page<Participant> getParticipants(Integer page, Integer pageSize);

}