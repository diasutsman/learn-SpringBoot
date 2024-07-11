package io.github.diasutsman.runnerz.run;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

//* Basically data class in kotlin */
public record Run(
        @Id Integer id,
        @NotEmpty String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive Integer miles,
        Location location,
        @Version Integer version) {
    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("Started on must be before completed on");
        }
    }
}
