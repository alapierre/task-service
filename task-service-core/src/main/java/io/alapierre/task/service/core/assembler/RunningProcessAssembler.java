package io.alapierre.task.service.core.assembler;

import io.alapierre.task.service.core.assembler.commons.AbstractAssembler;
import io.alapierre.task.service.core.converter.JsonConverter;
import io.alapierre.task.service.core.dto.RunningProcessDTO;
import io.alapierre.task.service.core.model.RunningProcess;
import org.modelmapper.ModelMapper;

/**
 * Created 04.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
public class RunningProcessAssembler extends AbstractAssembler<RunningProcess, RunningProcessDTO> {

    public RunningProcessAssembler() {
        var modelMapper = new ModelMapper();
        this.modelMapper = modelMapper;

        var typeMatch = modelMapper.createTypeMap(RunningProcess.class, RunningProcessDTO.class);

        typeMatch.addMappings(mapper -> mapper.map(RunningProcess::getJsonValues, RunningProcessDTO::setJsonValues));
        modelMapper.addConverter(new JsonConverter());
    }
}
