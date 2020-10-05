package io.alapierre.task.service.core.assembler;

import io.alapierre.task.service.core.model.ProcessDefinition;
import io.alapierre.task.service.core.model.ProcessStatus;
import io.alapierre.task.service.core.model.RunningProcess;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created 04.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
class RunningProcessAssemblerTest {

    @Test
    void testAssemblyJsonToMap() {

        var assembler = new RunningProcessAssembler();
        var dbo = new RunningProcess();

        String json = """
          {
            "firstName": "John",
            "lastName": "Doe",
            "age": 21
          }""";

        dbo.setJsonValues(json);
        dbo.setId(1L);
        dbo.setExternalId("1234");
        dbo.setOwner("jan.kowalski");
        dbo.setStatus(ProcessStatus.NEW);
        dbo.setProcessDefinition(new ProcessDefinition("procesKey"));

        var dto = assembler.assemblyToDto(dbo);

        System.out.println(dto);

        assertThat(dto.getJsonValues(), notNullValue());
        assertThat(dto.getExternalId(), is("1234"));
        assertThat(dto.getOwner(), is("jan.kowalski"));
        assertThat(dto.getStatus(), is(ProcessStatus.NEW));
        assertThat(dto.getProcessKey(), is("procesKey"));


    }


}
