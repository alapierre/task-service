package io.alapierre.task.service.core.service;

import io.alapierre.task.service.core.model.ProcessDefinition;
import io.alapierre.task.service.core.repository.ProcessDefinitionRepository;
import org.springframework.stereotype.Service;

/**
 * Created 04.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Service
public class ProcessDefinitionService extends CrudService<ProcessDefinition, String, ProcessDefinitionRepository> {

    protected ProcessDefinitionService(ProcessDefinitionRepository repository) {
        super(repository);
    }
}
