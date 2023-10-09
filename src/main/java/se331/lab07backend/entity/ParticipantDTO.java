package se331.lab07backend.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {
    Long id;
    String name;
    String telNo;
    @Builder.Default
    List<ParticipantEventDTO> eventHistory = new ArrayList<>();

}
