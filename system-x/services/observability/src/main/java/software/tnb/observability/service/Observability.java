package software.tnb.observability.service;

import software.tnb.common.account.NoAccount;
import software.tnb.common.service.ConfigurableService;
import software.tnb.observability.service.configuration.ObservabilityConfiguration;
import software.tnb.observability.validation.ObservabilityValidation;

import io.fabric8.kubernetes.client.http.HttpClient;

public abstract class Observability extends ConfigurableService<NoAccount, HttpClient, ObservabilityValidation, ObservabilityConfiguration> {

    @Override
    protected void defaultConfiguration() {
        getConfiguration().withDeployTracesUiPlugin(true)
            .withTempoStackName("tnb-tempostack");
    }
}
