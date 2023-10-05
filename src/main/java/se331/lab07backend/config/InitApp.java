package se331.lab07backend.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;
import se331.lab07backend.repository.EventRepository;
import se331.lab07backend.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        eventRepository.save(Event.builder()
            .category("Academic")
            .title("Midterm Exam")
            .description("A time for taking the exam")
            .location("CAMT Building")
            .date("3rd Sept")
            .time("3.00-4.00 pm.")
            .petAllowed(false)
            .organizer("CAMT").build());
        eventRepository.save(Event.builder()
            .category("Academic")
            .title("Commencement Day")
            .description("A time for celebration")
            .location("CMU Convention hall")
            .date("21th Jan")
            .time("8.00am-4.00 pm.")
            .petAllowed(false)
            .organizer("CMU").build());
        eventRepository.save(Event.builder()
            .category("Cultural")
            .title("Loy Krathong")
            .description("A time for Krathong")
            .location("Ping River")
            .date("21th Nov")
            .time("8.00-10.00 pm.")
            .petAllowed(false)
            .organizer("Chiang Mai").build());
        eventRepository.save(Event.builder()
            .category("Cultural")
            .title("Songkran")
            .description("Let's Play Water")
            .location("Chiang Mai Moat")
            .date("13th April")
            .time("10.00am - 6.00 pm.")
            .petAllowed(true)
            .organizer("Chiang Mai Municipality").build());

        organizerRepository.save(Organizer.builder()
            .organizationName("Kat Laydee")
            .address("Somewhere.")
            .build());
        organizerRepository.save(Organizer.builder()
            .organizationName("Fern Pollin")
            .address("Somewhere.")
            .build());
        organizerRepository.save(Organizer.builder()
            .organizationName("Carey Wales")
            .address("Somewhere.")
            .build());
        organizerRepository.save(Organizer.builder()
            .organizationName("Dawg Dahd")
            .address("Somewhere.")
            .build());
        organizerRepository.save(Organizer.builder()
            .organizationName("Kahn Opiner")
            .address("Somewhere.")
            .build());
        organizerRepository.save(Organizer.builder()
            .organizationName("Brody Kill")
            .address("Somewhere.")
            .build());
    }
}

