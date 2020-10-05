package io.alapierre.task.service.core.repository;

import io.alapierre.task.service.core.model.ProcessStatus;
import io.alapierre.task.service.core.model.RunningProcess;
import io.alapierre.task.service.core.model.virtual.ProcessStatusCounted;
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
public interface RunningProcessRepository extends JpaRepository<RunningProcess, Long>, JpaSpecificationExecutor<RunningProcess> {

    List<RunningProcess> findByStatus(ProcessStatus processStatus);

    long countByStatus(ProcessStatus serviceStatus);

    @Query("select process.processDefinition.key from RunningProcess process where process.id = ?1")
    Optional<String> serviceKeyByRunningServiceId(long id);

    @Query("SELECT new io.alapierre.task.service.core.model.virtual.ProcessStatusCounted(s.status, COUNT(s)) FROM RunningProcess AS s GROUP BY s.status")
    List<ProcessStatusCounted> countInAllStatuses();

}
