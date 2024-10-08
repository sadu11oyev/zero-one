package pdp.uz.zerooneproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("My REST API")
                .description("Some custom description of API.")
                .version("1.0").contact(new Contact().name("Sallo Szrajbman")
                        .email( "www.baeldung.com").url("sadu11oyev_04"))
                .license(new License().name("License of API")
                        .url("API license URL")));
    }
}
