package se331.lab07backend.dao;

import jakarta.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import se331.lab07backend.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;
    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .organizationName("Kat Laydee")
                .address("Somewhere.")
                .build());

        organizerList.add(Organizer.builder()
                .id(345L)
                .organizationName("Fern Pollin")
                .address("Somewhere.")
                .build());

        organizerList.add(Organizer.builder()
                .id(678L)
                .organizationName("Carey Wales")
                .address("Somewhere.")
                .build());

        organizerList.add(Organizer.builder()
                .id(910L)
                .organizationName("Dawg Dahd")
                .address("Somewhere.")
                .build());

        organizerList.add(Organizer.builder()
                .id(101L)
                .organizationName("Kahn Opiner")
                .address("Somewhere.")
                .build());

        organizerList.add(Organizer.builder()
                .id(112L)
                .organizationName("Brody Kill")
                .address("Somewhere.")
                .build());
    }
    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex+pageSize),PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(org -> org.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer org) {
        org.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(org);
        return org;
    }
}