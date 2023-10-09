package se331.lab07backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.lab07backend.dao.OrganizerDao;
import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    final OrganizerDao organizerDao;
    @Override
    public List<Organizer> getAllOrganizer() {
        return organizerDao.getOrganizer(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Organizer> getOrganizer(Integer page, Integer pageSize) {
        return organizerDao.getOrganizer(PageRequest.of(page,pageSize));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerDao.getOrganizer(id);
    }

    @Override
    @Transactional
    public Organizer save(Organizer organizer) {
        return organizerDao.save(organizer);
    }
}

