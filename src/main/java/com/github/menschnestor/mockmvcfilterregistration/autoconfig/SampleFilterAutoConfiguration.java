package com.github.menschnestor.mockmvcfilterregistration.autoconfig;

import com.github.menschnestor.mockmvcfilterregistration.SampleFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

@Configuration
public class SampleFilterAutoConfiguration {
    @Bean
    public SampleFilter sampleFilter() {
        return new SampleFilter();
    }

    @Bean
    public FilterRegistrationBean sampleFilterRegistrationBean(final SampleFilter filter) {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
        filterRegistrationBean.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }
}
