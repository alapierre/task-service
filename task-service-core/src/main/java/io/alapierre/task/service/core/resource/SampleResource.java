package io.alapierre.task.service.core.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created 02.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@RestController
@RequestMapping("/test/hello")
public class SampleResource {

    @GetMapping
    public String sayHello() {

        var result = "Hello World at: " + LocalDateTime.now();

        return result;
    }

}
