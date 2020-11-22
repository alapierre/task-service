package io.alapierre.task.service.core.resource;

import io.alapierre.task.service.core.model.ProcessDefinition;
import io.alapierre.task.service.core.service.ProcessDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/process/definition")
@RequiredArgsConstructor
public class ProcessDefinitionResource {

    private final ProcessDefinitionService processDefinitionService;

    @GetMapping("/")
    public List<ProcessDefinition> loadProcessDefinitions() {
        return processDefinitionService.getAll();
    }

}
