package codingtechniques.WebMvcConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.Validator;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

public class MyConfigMvc extends DelegatingWebMvcConfiguration {

    @Bean
    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {

        return new RequestMappingHandlerMapping();

    }

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping(
            ContentNegotiationManager contentNegotiationManager, FormattingConversionService conversionService,
            ResourceUrlProvider resourceUrlProvider) {
        return super.requestMappingHandlerMapping(contentNegotiationManager, conversionService, resourceUrlProvider);
    }

    @Override
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(
            ContentNegotiationManager contentNegotiationManager, FormattingConversionService conversionService,
            Validator validator) {
        return super.requestMappingHandlerAdapter(contentNegotiationManager, conversionService, validator);
    }

}
