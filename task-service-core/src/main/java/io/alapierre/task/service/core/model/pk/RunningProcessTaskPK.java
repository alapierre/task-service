package io.alapierre.task.service.core.model.pk;

import io.alapierre.task.service.core.model.RunningProcess;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created 30.09.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RunningProcessTaskPK implements Serializable {

    @NotEmpty
    @Size(max = 128)
    private String stepKey;

    @ManyToOne(optional = false)
    private RunningProcess process;

}
