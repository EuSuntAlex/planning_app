package com.example.demo.participant.querydto;

import com.example.demo.participant.commanddto.ParticipantAddDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(value = "participant", schema = "plan")
public class Participant {

    @Id
    private Long id;

    @Column("email")
    private String email;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("created_at")
    private LocalDateTime createdAt;

    public Participant(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = LocalDateTime.now();
    }
    public Participant(ParticipantAddDto participantAddDto) {
        if (participantAddDto == null) {
            throw new IllegalArgumentException("ParticipantAddDto cannot be null");
        }

        if (participantAddDto.getEmail() == null || participantAddDto.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        this.email = participantAddDto.getEmail().trim();

        if (participantAddDto.getFirstName() == null || participantAddDto.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name is required");
        }
        this.firstName = participantAddDto.getFirstName().trim();

        if (participantAddDto.getLastName() == null || participantAddDto.getLastName().trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is required");
        }
        this.lastName = participantAddDto.getLastName().trim();
    }

    // required by Spring Data JDBC
    protected Participant() {
    }

    // getters (setters optional)
}
