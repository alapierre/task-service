package io.alapierre.task.service.core.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created 04.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Data
public abstract class BaseDTO {

    protected int version;

    protected LocalDateTime created;

    protected LocalDateTime lastModified;

    protected String createdBy;

    protected String lastModifiedBy;

    protected String behalfCreatedBy;

    protected String behalfLastModifiedBy;

}
