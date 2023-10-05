package se331.lab07backend.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
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
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex,firstIndex+pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(org -> org.getId().equals(id)).findFirst().orElse(null);
    }
}