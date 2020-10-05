package io.alapierre.task.service.core.repository;

import io.alapierre.task.service.core.model.RunningProcessTask;
import io.alapierre.task.service.core.model.pk.RunningProcessTaskPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Repository
public interface RunningProcessTaskRepository extends JpaRepository<RunningProcessTask, RunningProcessTaskPK>, JpaSpecificationExecutor<RunningProcessTask> {

    @Query("select task from RunningProcessTask task where task.key.process.id = ?1")
    List<RunningProcessTask> findByServiceDefinitionKey(long runningProcessId);

    Optional<RunningProcessTask> getByKeyProcessIdAndKeyStepKey(long processId, String stepKey);

}
