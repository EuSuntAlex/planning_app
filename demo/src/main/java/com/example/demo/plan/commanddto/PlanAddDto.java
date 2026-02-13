package com.example.demo.plan.commanddto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlanAddDto {
    String title;
    // TODO: plannedDate de adaugat
    String description;
    String location;
}
