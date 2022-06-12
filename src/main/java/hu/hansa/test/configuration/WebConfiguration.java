package hu.hansa.test.configuration;


import hu.hansa.test.converter.purchase.PurchaseToPurchaseDto;
import hu.hansa.test.converter.purchaseproduct.PurchaseProductToPurchaseProductDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAsync
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addConverter(new PurchaseToPurchaseDto((ConversionService) registry));
        registry.addConverter(new PurchaseProductToPurchaseProductDto((ConversionService) registry));
        // Use it when need to add dependency to the converter
    }
}
