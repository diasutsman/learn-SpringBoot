package io.github.diasutsman.runnerz.run;

import java.time.LocalDateTime;

//* Basically data class in kotlin */
public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location) {

}
