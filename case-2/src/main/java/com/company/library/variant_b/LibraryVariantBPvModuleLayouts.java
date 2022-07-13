package com.company.library.variant_b;

import java.util.List;

/**
 * This variant defines interfaces for communicating data both ways between the app and the library
 */
public class LibraryVariantBPvModuleLayouts {
    public List<PvModulePosition> optimalLayoutFor(RoofFace roofFace, PvModuleDefinition pvModuleDefinition) {
        // Assume complicated logic here
        return List.of();
    }

    public interface RoofFace {
        double slopeAngleInDegrees();
    }

    public interface PvModuleDefinition {
        double lengthInMeters();

        double widthInMeters();
    }

    public interface PvModulePosition {
    }
}
