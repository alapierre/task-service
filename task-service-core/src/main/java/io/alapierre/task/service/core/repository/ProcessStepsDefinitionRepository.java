package io.alapierre.task.service.core.repository;

import io.alapierre.task.service.core.model.ProcessStepsDefinition;
import io.alapierre.task.service.core.model.pk.StepKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Repository
public interface ProcessStepsDefinitionRepository extends JpaRepository<ProcessStepsDefinition, StepKey>, JpaSpecificationExecutor<ProcessStepsDefinition> {

    @Query("select step from ProcessStepsDefinition step where step.key.processDefinition.key = ?1 order by step.lp")
    List<ProcessStepsDefinition> findByServiceDefinitionKey(String processDefinitionKey);

}
