package se331.lab07backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.lab07backend.dao.ParticipantDao;
import se331.lab07backend.entity.Participant;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService{
    final ParticipantDao participantDao;
    @Override
    public List<Participant> getAllParticipants() {
        return participantDao.getParticipant(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Participant> getParticipants(Integer page, Integer pageSize) {
        return participantDao.getParticipant(PageRequest.of(page,pageSize));
    }
}

