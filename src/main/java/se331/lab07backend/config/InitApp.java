package se331.lab07backend.config;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;
import se331.lab07backend.entity.Participant;
import se331.lab07backend.repository.EventRepository;
import se331.lab07backend.repository.OrganizerRepository;
import se331.lab07backend.repository.ParticipantRepository;
import se331.lab07backend.security.user.Role;
import se331.lab07backend.security.user.User;
import se331.lab07backend.security.user.UserRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    final UserRepository userRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
            .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
            .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
            .name("ChiangMai").build());

        Participant par1, par2, par3, par4, par5;
        par1 = participantRepository.save(Participant.builder()
            .name("P1")
            .telNo("011")
            .build());
        par2 = participantRepository.save(Participant.builder()
            .name("P2")
            .telNo("212")
            .build());
        par3 = participantRepository.save(Participant.builder()
            .name("P3")
            .telNo("033")
            .build());
        par4 = participantRepository.save(Participant.builder()
            .name("P4")
            .telNo("044")
            .build());
        par5 = participantRepository.save(Participant.builder()
            .name("P5")
            .telNo("052")
            .build());

        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        tempEvent.getParticipants().add(par1);
        tempEvent.getParticipants().add(par2);
        tempEvent.getParticipants().add(par3);
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        tempEvent.getParticipants().add(par1);
        tempEvent.getParticipants().add(par2);
        tempEvent.getParticipants().add(par3);
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        tempEvent.getParticipants().add(par1);
        tempEvent.getParticipants().add(par2);
        tempEvent.getParticipants().add(par3);
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        org2.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        tempEvent.getParticipants().add(par4);
        tempEvent.getParticipants().add(par2);
        tempEvent.getParticipants().add(par5);
        par4.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par5.getEventHistory().add(tempEvent);
        org3.getOwnEvents().add(tempEvent);

        addUser();
    }

    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
            .username("admin")
            .password(encoder.encode("admin"))
            .firstname("admin")
            .lastname("admin")
            .email("admin@admin.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build();
        user2 = User.builder()
            .username("user")
            .password(encoder.encode("user"))
            .firstname("user")
            .lastname("user")
            .email("enabled@user.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build();
        user3 = User.builder()
            .username("disableUser")
            .password(encoder.encode("disableUser"))
            .firstname("disableUser")
            .lastname("disableUser")
            .email("disableUser@user.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build();

        
        user1.getRoles().add(Role.ROLE_ADMIN);
        user1.getRoles().add(Role.ROLE_DISTRIBUTOR);
        user2.getRoles().add(Role.ROLE_DISTRIBUTOR);
        user3.getRoles().add(Role.ROLE_DISTRIBUTOR);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}

