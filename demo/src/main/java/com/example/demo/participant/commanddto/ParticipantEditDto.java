package com.example.demo.participant.commanddto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ParticipantEditDto {
    //TODO path variable
    private long id;
    private String firstName;
    private String lastName;
    private String email;


}
