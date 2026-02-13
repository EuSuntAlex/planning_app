package com.example.demo.plan.querydto;

import com.example.demo.plan.commanddto.PlanAddDto;
import com.example.demo.plan.commanddto.PlanEditDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plan")
public class PlanController {
    private final PlanRepository planRepository;

    public PlanController(PlanRepository planRepository){
        this.planRepository = planRepository;
    }


@PostMapping("/add")
    public ResponseEntity<?> addPlan(@Valid @RequestBody PlanAddDto planAddDto) {
        // TODO:
        //        PlanEntity savedPlan = planService.createPlan(request);
        Plan plan = new Plan(planAddDto);
        planRepository.save(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(planAddDto);
    }
    // TODO: endpoint /edit
    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editPlan(@Valid @RequestBody PlanEditDto planEditDto, @PathVariable Long id) {

        Optional<Plan> existingPlan = planRepository.findById(id);

        if (existingPlan.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Plan not found with id: " + id);
        }

        Plan updatedPlan = existingPlan.get();

        if (planEditDto.getTitle() != null) {
            updatedPlan.setTitle(planEditDto.getTitle());
        }

        if (planEditDto.getDescription() != null) {
            updatedPlan.setDescription(planEditDto.getDescription());
        }

        if (planEditDto.getLocation() != null) {
            updatedPlan.setLocation(planEditDto.getLocation());
        }
        Plan savedPlan = planRepository.save(updatedPlan);
        return ResponseEntity.ok(savedPlan);
    }

    // TODO: endpoint /{id} -> getById
    @GetMapping("/{id}")
    public Optional<Plan> getById(@PathVariable Long id) {
        return planRepository.findById(id);
    }

    // TODO: endpoint /all  -> getAll()
    @GetMapping("/all")
    public List<Plan> getAll() {
        List<Plan> allPlans= new ArrayList<>();
        for (Plan p : planRepository.findAll()) {
            allPlans.add(p);
        }
        return allPlans;
    }


    // TODO: De adaugat getByIds
    @GetMapping("/test")
    public String testEndpoint() {
        return "prima painga -> endpoint de test";
    }

}

