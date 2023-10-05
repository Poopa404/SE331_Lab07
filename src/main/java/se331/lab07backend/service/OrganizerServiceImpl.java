package se331.lab07backend.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab07backend.dao.OrganizerDao;
import se331.lab07backend.entity.Organizer;


@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    final OrganizerDao orgDao;
    @Override
    public Integer getOrganizerSize() {
        return orgDao.getOrganizerSize();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return orgDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return orgDao.getOrganizer(id);
    }

    @Override
    public Organizer save(Organizer org) {
        return orgDao.save(org);
    }
}