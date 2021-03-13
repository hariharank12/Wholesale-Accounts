package org.anz.wholesale.controller;

import lombok.extern.slf4j.Slf4j;
import org.anz.wholesale.config.CustomerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hariharank12 on 25/11/20.
 */
@Slf4j
@RestController
@RequestMapping("/spring")
@Validated
public class ProfileController {

    private CustomerConfiguration customerConfiguration;

    @Autowired
    ProfileController(final CustomerConfiguration customerConfiguration) {
        this.customerConfiguration = customerConfiguration;
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<String> getSpringProfile() {
        log.info("Retrieving spring profile");
        return ResponseEntity.ok().body(customerConfiguration.toString());
    }

}
