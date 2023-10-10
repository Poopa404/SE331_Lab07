package se331.lab07backend.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.auto.value.AutoValue.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab07backend.security.user.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerAuthDTO {
    Long id;
    String name;
    List<Role> roles = new ArrayList<>();
}
