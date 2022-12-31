package si.fri.rso.skupina1.narocila.services.clients;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import si.fri.rso.skupina1.narocila.lib.TranslateRequest;

import javax.enterprise.context.Dependent;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.concurrent.CompletionStage;

@Path("translate/v2")
@RegisterRestClient(configKey="deep-translate-api")
@ClientHeaderParam(name="X-RapidAPI-Key", value="{getApiKey}")
@ClientHeaderParam(name="X-RapidAPI-Host", value="{getApiHost}")
@Dependent
public interface TranslateApiClient {


    @POST
    String translate(TranslateRequest translateRequest);

    default String getApiKey() {
        return ConfigurationUtil.getInstance().get("integrations.deep-translate.apiKey").get();
    }

    default String getApiHost() {
        return ConfigurationUtil.getInstance().get("integrations.deep-translate.apiHost").get();
    }

}
