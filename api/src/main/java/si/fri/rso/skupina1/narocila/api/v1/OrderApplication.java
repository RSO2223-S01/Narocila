package si.fri.rso.skupina1.narocila.api.v1;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Orders API", version = "v1", contact = @Contact(email = "aa2068@student.uni-lj.si"), license = @License(name = "dev"), description = "API for delivery app orders."), servers = @Server(url = "http://localhost:8080/"))
@ApplicationPath("/v1")
public class OrderApplication extends Application {

}
