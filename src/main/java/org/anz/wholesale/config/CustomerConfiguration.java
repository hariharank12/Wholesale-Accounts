package org.anz.wholesale.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * Created by hariharank12 on 16/01/21.
 */
@Configuration
@Slf4j
public class CustomerConfiguration {

    @Value("${customer.host}")
    private String customerHost;

    @Value("${customer.port}")
    private String customerPort;

    @Override
    public String toString() {
        log.debug("Customer Configuration details host {} and port {}",
                customerHost, customerPort);

        return "CustomerConfiguration{" +
                "host='" + customerHost + '\'' +
                ", port='" + customerPort + '\'' +
                '}';
    }

}
