/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xy.inc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Hugo
 */
@Configuration
@ComponentScan("com.xy.inc")
@Import({PersistenceContextTest.class})
public class ApplicationContextTest {
    
    @Configuration
    @PropertySource("classpath:application.properties")
    static class ApplicationProperties {}
}
