package io.alapierre.task.service.core.model;

import io.alapierre.task.service.core.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditOverride;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

/**
 * Created 21.09.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Entity
@Getter
@Setter
@AuditOverride(forClass = BaseEntity.class)
public class RunningProcess extends BaseEntity {

    @ManyToOne(optional = false)
    private ProcesDefinition processDefinition;

    @Size(max = 256)
    private String externalId;

    @NotEmpty
    @Size(max = 128)
    private String owner;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProcessStatus status;

    @Column(name = "json_values")
    @Type(type = "jsonb")
    private Map<String, String> values;

    private boolean renewal;

}
