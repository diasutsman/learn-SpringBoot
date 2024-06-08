package io.github.diasutsman.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    // @Autowired // ! Not Recommended because it basically untestable
    private RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> getAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run getById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);

        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }

        return run.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void createOne(
            /** Validation api runs every time the run instance get created */
            @Valid
            /** Create run instance from request body */
            @RequestBody Run run) {
        runRepository.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{identifier}")
    void updateOne(/** Validation api runs every time the run instance get created */
    @Valid
    /** Create run instance from request body */
    @RequestBody Run run, @PathVariable Integer identifier) {
        runRepository.update(run, identifier);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{identifier}")
    void deleteOne(@PathVariable Integer identifier) {
        runRepository.delete(identifier);
    }

}
