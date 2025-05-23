package io.kestra.plugin.serdes;

import io.kestra.core.junit.annotations.ExecuteFlow;
import io.kestra.core.junit.annotations.KestraTest;
import io.kestra.core.models.executions.Execution;
import io.kestra.core.models.flows.State;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@KestraTest(startRunner = true)
class RunnerTest {
    @Test
    @ExecuteFlow("sanity-checks/avro.yaml")
    void avro(Execution execution) {
        assertThat(execution.getTaskRunList(), hasSize(5));
        assertThat(execution.getState().getCurrent(), is(State.Type.SUCCESS));
    }

    @Test
    @ExecuteFlow("sanity-checks/csv.yaml")
    void csv(Execution execution) {
        assertThat(execution.getTaskRunList(), hasSize(4));
        assertThat(execution.getState().getCurrent(), is(State.Type.SUCCESS));
    }

    @Test
    @ExecuteFlow("sanity-checks/excel.yaml")
    void excel(Execution execution) {
        assertThat(execution.getTaskRunList(), hasSize(4));
        assertThat(execution.getState().getCurrent(), is(State.Type.SUCCESS));
    }

    @Test
    @ExecuteFlow("sanity-checks/infer_ion_avro.yaml")
    void infer_ion_avro(Execution execution) {
        assertThat(execution.getTaskRunList(), hasSize(9));
        assertThat(execution.getState().getCurrent(), is(State.Type.SUCCESS));
    }

    @Test
    @ExecuteFlow("sanity-checks/infer_ion_parquet.yaml")
    void infer_ion_parquet(Execution execution) {
        assertThat(execution.getTaskRunList(), hasSize(5));
        assertThat(execution.getState().getCurrent(), is(State.Type.SUCCESS));
    }
}
