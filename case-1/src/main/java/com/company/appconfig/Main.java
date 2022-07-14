package com.company.appconfig;

import com.company.app.PvModuleLayouts;
import com.company.app.pvmodulelayouts.DefaultPvModuleLayouts;
import com.company.app.pvmodulelayouts.layoutspecification.RoofSlopeDependentLayoutSpecification;

// @Configuration
public class Main {
    // @Bean
    public PvModuleLayouts pvModuleLayouts() {
        return new DefaultPvModuleLayouts(RoofSlopeDependentLayoutSpecification::new);
    }
}
