package com.oc.poc.simplehostname;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.MetricsServlet;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pchaivong on 11/10/2017 AD.
 */

@Configuration
@ConditionalOnClass(CollectorRegistry.class)
@AutoConfigureBefore(MetricRepositoryAutoConfiguration.class)
public class PrometheusAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public CollectorRegistry metricRegistry() {
        return new CollectorRegistry();
    }

    @Bean
    @ConditionalOnMissingBean({PrometheusMetricService.class, CounterService.class, GaugeService.class})
    public PrometheusMetricService prometheusMetricServices(CollectorRegistry metricRegistry) {
        return new PrometheusMetricService(metricRegistry);
    }

    @Bean
    public ServletRegistrationBean registerPrometheusExporterServlet(CollectorRegistry metricRegistry) {
        return new ServletRegistrationBean(new MetricsServlet(metricRegistry), "/prometheus");
    }
}
