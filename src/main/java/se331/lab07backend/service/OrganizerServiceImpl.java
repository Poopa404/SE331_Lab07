package se331.lab07backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab07backend.dao.EventDao;
import se331.lab07backend.dao.OrganizerDao;
import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    final OrganizerDao orgDao;
    @Override
    public Integer getOrganizerSize() {
        return orgDao.getOrganizerSize();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return orgDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return orgDao.getOrganizer(id);
    }
}