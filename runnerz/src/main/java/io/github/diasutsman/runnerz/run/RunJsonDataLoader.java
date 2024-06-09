package io.github.diasutsman.runnerz.run;

import java.io.IOException;
import java.io.InputStream;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);

    private final JDBCClientRunRepository runRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(JDBCClientRunRepository runRepository, ObjectMapper objectMapper) {
        this.runRepository = runRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (runRepository.count() != 0) {
            log.info("Not loading runs from json file because table is already filled");
            return;
        }

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
            Runs runs = objectMapper.readValue(inputStream, Runs.class);
            log.info("Reading {} runs from json file", runs.runs().size());
            runRepository.createMany(runs.runs());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read json data", e);
        }
    }

}
