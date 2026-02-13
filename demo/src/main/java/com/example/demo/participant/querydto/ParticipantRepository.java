package com.example.demo.participant.querydto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository
        extends CrudRepository<Participant, Long> {

    // TODO: DE CE AM PUS METODA ASTA AICI??? CE SENS ARE??
    Optional<Participant> findByEmail(String email);
}