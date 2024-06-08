package io.github.diasutsman.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<Run>();

    public List<Run> findAll() {
        return runs;
    }

    public Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    public void create(Run run) {
        runs.add(run);
    }

    public void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isEmpty()) {
            return;
        }
        runs.set(runs.indexOf(existingRun.get()), run);
    }

    public void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    public void init() {
        runs.add(new Run(
                1,
                "Run 1",
                LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                5,
                Location.OUTDOOR));
        runs.add(new Run(
                2,
                "Run 2",
                LocalDateTime.now().plus(1, ChronoUnit.HOURS),
                LocalDateTime.now().plus(2, ChronoUnit.HOURS),
                5,
                Location.OUTDOOR));
    }
}
