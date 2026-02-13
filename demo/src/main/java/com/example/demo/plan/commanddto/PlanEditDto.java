package com.example.demo.plan.commanddto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PlanEditDto {
    String title;
    String description;
    String location;
}
