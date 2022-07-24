package com.company.appconfig;

import com.company.app.PvModuleDefinition;
import com.company.app.pvmodulelayouts.defaultlayouts.DefaultPvModuleLayouts;

public final class App {
    public static void main(String[] args) {
        new DefaultPvModuleLayouts().optimalLayoutFor(
            () -> Double.parseDouble(args[0]),
            new PvModuleDefinition() {
                @Override
                public double widthInMeters() {
                    return Double.parseDouble(args[1]);
                }

                @Override
                public double lengthInMeters() {
                    return Double.parseDouble(args[2]);
                }
            }
        );
    }
}
