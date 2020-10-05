package io.alapierre.task.service.core.assembler.commons;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
public interface Assembler<T1, T2>  {

    T1 assemblyToDbo(T2 var1);

    default List<T1> assemblyToDbo(List<T2> dto) {
        return (List)dto.stream().map(this::assemblyToDbo).collect(Collectors.toList());
    }

    T2 assemblyToDto(T1 var1);

    default List<T2> assemblyToDto(List<T1> dbo) {
        return (List)dbo.stream().map(this::assemblyToDto).collect(Collectors.toList());
    }
}
