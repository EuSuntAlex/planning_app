package com.example.demo.plan.querydto;


// data object model  clasa prin care spunem ce vrem sa primim

import com.example.demo.plan.commanddto.PlanAddDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "plan", schema = "plan")
public class Plan {
    @Id
    @NotNull(message = "There must always be an id")
    long id;
    @NotBlank(message = "Titlul este obligatoriu!")
    String title;
    @NotNull(message = "Data si ora sunt obligatorii!")
    LocalDateTime createdAt;
    // TODO: plannedDate de adaugat
    String description;
    @NotNull(message = "Location is null")
    String location;
    public Plan(PlanAddDto planAddDto) {
        if (planAddDto.getTitle() != null && !planAddDto.getTitle().trim().isEmpty()) {
            this.title = planAddDto.getTitle().trim();
        }

        this.description = planAddDto.getDescription();

        if (planAddDto.getLocation() != null && !planAddDto.getLocation().trim().isEmpty()) {
            this.location = planAddDto.getLocation().trim();
        }
        this.createdAt = LocalDateTime.now();
    }
}