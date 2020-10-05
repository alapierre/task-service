package io.alapierre.task.service.core.assembler.commons;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.ParameterizedType;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
public abstract class AbstractAssembler<T1, T2> implements Assembler<T1, T2>{

    protected ModelMapper modelMapper;
    protected Class<T1> dboClassType;
    protected Class<T2> dtoClassType;

    public AbstractAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.extractGenericTypes();
    }

    public AbstractAssembler() {
        this.modelMapper = this.prepareDefaultModelMapper();
        this.extractGenericTypes();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void extractGenericTypes() {
        this.dboClassType = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dtoClassType = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private ModelMapper prepareDefaultModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    public T1 assemblyToDbo(T2 dto) {
        return dto == null ? null : this.modelMapper.map(dto, this.dboClassType);
    }

    public T2 assemblyToDto(T1 dbo) {
        return dbo == null ? null : this.modelMapper.map(dbo, this.dtoClassType);
    }

}
