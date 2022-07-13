package com.company.library.variant_a;

import java.util.List;

/**
 * This variant defines records for communicating data both ways between the app and the library
 */
public class LibraryVariantAPvModuleLayouts {
    public List<PvModulePosition> optimalLayoutFor(RoofFace roofFace, PvModuleDefinition pvModuleDefinition) {
        // Assume complicated logic here
        return List.of();
    }

    public record RoofFace(
            double slopeAngleInDegrees
    ) {
    }

    public record PvModuleDefinition(
            double lengthInMeters,
            double widthInMeters
    ) {
    }

    public record PvModulePosition() {
    }
}
