package io.alapierre.task.service.core.model.virtual;

import io.alapierre.task.service.core.model.ProcessStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created 30.09.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessStatusCounted {

    @NotNull
    private ProcessStatus status;

    private long count;

}
