package io.alapierre.task.service.core.repository;

import io.alapierre.task.service.core.model.ProcessDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Repository
public interface ProcessDefinitionRepository extends JpaRepository<ProcessDefinition, String>, JpaSpecificationExecutor<ProcessDefinition> {
}
