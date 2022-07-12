package com.company.app.pvmodulelayouts.layoutspecification;

import com.company.app.PvModuleDefinition;
import com.company.app.PvModulePosition;
import com.company.app.pvmodulelayouts.LayoutSpecification;
import com.company.app.pvmodulelayouts.LayoutTile;

import java.util.stream.Stream;

/**
 * Defines how we want to organize PV modules when mounted along the roof face plane.
 * <p>
 * Let's assume the logic is that PV modules are always mounted individually and in portrait orientation.
 * (i.e. the unit of placement (layout tile) is a single PV module in portrait orientation)
 */
public class PvModulesMountedOnRoofFacePlaneLayoutSpecification implements LayoutSpecification {
    private final PvModuleDefinition pvModuleDefinition;

    public PvModulesMountedOnRoofFacePlaneLayoutSpecification(PvModuleDefinition pvModuleDefinition) {
        this.pvModuleDefinition = pvModuleDefinition;
    }

    @Override
    public double tileWidth() {
        return pvModuleDefinition.widthInMeters();
    }

    @Override
    public double tileLength() {
        return pvModuleDefinition.lengthInMeters();
    }

    @Override
    public Stream<PvModulePosition> splitIntoPvModulePositions(LayoutTile layoutTile) {
        return Stream.of(
                // Here we would build a single PvModulePosition from a single layout tile
        );
    }
}
