package com.example.application;

import com.example.configuration.CoinCalculatorConfiguration;
import com.example.resource.CoinCalculatorResource;
import com.example.service.CoinCalculatorService;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;
import jakarta.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;


public class CoinCalculatorApplication extends Application<CoinCalculatorConfiguration> {
    public static void main(String[] args) throws Exception {
        new CoinCalculatorApplication().run(args);
    }

    @Override
    public void run(CoinCalculatorConfiguration configuration, Environment environment) {
        final CoinCalculatorService service = new CoinCalculatorService();
        final CoinCalculatorResource resource = new CoinCalculatorResource(service);

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(null, false, "/*");


        environment.jersey().register(resource);
    }
}