package se331.lab07backend.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import se331.lab07backend.entity.Event;
import se331.lab07backend.entity.Organizer;
import se331.lab07backend.service.OrganizerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
    List<Organizer> organizerList;
    final OrganizerService organizerService;
    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerList(@RequestParam(value ="_limit", required = false) Integer perPage,
                                           @RequestParam(value ="_page",required = false) Integer page){
        Page<Organizer> pageOutput = organizerService.getOrganizers(perPage, page);                                    
        HttpHeaders responseHeader = new HttpHeaders();
        return new ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);
    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganizer(id);
        if (output != null){
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/organizers")
    public ResponseEntity<?> addEvent(@RequestBody Organizer event){
        Organizer output = organizerService.save(event);
        return ResponseEntity.ok(output);
    }
}
