package io.alapierre.task.service.core.model;

import io.alapierre.task.service.core.model.base.BaseEntityNoId;
import io.alapierre.task.service.core.model.pk.RunningProcessTaskPK;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 * Created 21.09.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RunningProcessTask extends BaseEntityNoId {

    @EmbeddedId
    private RunningProcessTaskPK key;

    private LocalDate executionDate;

    private LocalDate reminderDate;

    private LocalTime reminderTime;

    private boolean na;

    @Column(name = "json_values")
    @Type(type = "jsonb")
    private Map<String, String> values;
}
