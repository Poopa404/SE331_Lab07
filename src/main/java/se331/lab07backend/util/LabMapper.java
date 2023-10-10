package se331.lab07backend.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.EventDTO;
import se331.lab07backend.entity.Organizer;
import se331.lab07backend.entity.OrganizerAuthDTO;
import se331.lab07backend.entity.OrganizerDTO;
import se331.lab07backend.entity.Participant;
import se331.lab07backend.entity.ParticipantDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventDto(List<Event> events);
    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);
    ParticipantDTO getParticipantDTO(Participant participant);
    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);
    @Mapping(target = "roles", source = "user.roles")
    OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer);
}
