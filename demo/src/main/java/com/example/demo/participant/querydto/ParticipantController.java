package com.example.demo.participant.querydto;

import com.example.demo.participant.commanddto.ParticipantAddDto;
import com.example.demo.participant.commanddto.ParticipantEditDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/participant/")
public class ParticipantController {
    // inject repository -> ParticipantRepository.save
    private final ParticipantRepository participantRepository;

    public ParticipantController(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    // endpoint de add
    @PostMapping("/add")
    public ResponseEntity<?> addParticipant(@Valid @RequestBody ParticipantAddDto addParticipant) {
        Participant participant = new Participant(addParticipant); // am modificat aici
        participantRepository.save(participant);
        return ResponseEntity.ok("okayyyyyy");
    }

    // endpoint de modificare
    @PostMapping("/edit")
    public ResponseEntity<?> editParticipant(
            @Valid @RequestBody ParticipantEditDto participant) {

        Optional<Participant> existingParticipant =
                participantRepository.findById(participant.getId());

        if (existingParticipant.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Participant not found");
        }

        Participant updated = existingParticipant.get();
        if (participant.getEmail() != null) {
            updated.setEmail(participant.getEmail());
        }
        if (participant.getFirstName() != null) {
            updated.setFirstName(participant.getFirstName());
        }
        if (participant.getLastName() != null) {
            updated.setLastName(participant.getLastName());
        }
        participantRepository.save(updated);

        return ResponseEntity.ok(updated);
    }

    // endpoint getbyid
    @GetMapping("{id}")
    // TODO DTO pentru afisari
    public Optional<Participant> getById(@PathVariable long id) {
        return participantRepository.findById(id);
    }

    //endpoint getAll -> refacem pentru paginal
    @GetMapping("getAll")
    public List<Participant> getAllParticipants() {
        List<Participant> found = new ArrayList<>();
        for(Participant p : participantRepository.findAll()) {
            found.add(p);
        }
        return found;
    }
    //endpoint getByManyIds
    // TODO altDto
    @GetMapping
    public ResponseEntity<List<Participant>> getByIds(
            @RequestParam List<Long> ids
    ) {
        // TODO Add @Query
        List<Participant> participants = (List<Participant>) participantRepository.findAllById(ids);
        return ResponseEntity.ok(participants);
    }

}

