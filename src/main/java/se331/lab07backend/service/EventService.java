package se331.lab07backend.service;

import se331.lab07backend.entity.Event;

import org.springframework.data.domain.Page;

public interface EventService {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
    Event save(Event event);

}
