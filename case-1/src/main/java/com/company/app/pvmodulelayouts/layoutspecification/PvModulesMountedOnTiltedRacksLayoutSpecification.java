package com.company.app.pvmodulelayouts.layoutspecification;

import com.company.app.PvModuleDefinition;
import com.company.app.PvModulePosition;
import com.company.app.pvmodulelayouts.LayoutSpecification;
import com.company.app.pvmodulelayouts.LayoutTile;

import java.util.stream.Stream;

/**
 * Defines how we want to organize PV modules when mounted tilted racks (which themselves are mounted on e.g. flat roof).
 * <p>
 * Let's assume the logic is that PV modules are always mounted in rows of 3 in landscape orientation
 * (i.e. the unit of placement (layout tile) is a group of 3 PV modules in landscape orientation)
 */
public class PvModulesMountedOnTiltedRacksLayoutSpecification implements LayoutSpecification {
    private final PvModuleDefinition pvModuleDefinition;

    public PvModulesMountedOnTiltedRacksLayoutSpecification(PvModuleDefinition pvModuleDefinition) {
        this.pvModuleDefinition = pvModuleDefinition;
    }

    @Override
    public double tileWidth() {
        // In landscape orientation the longer side of the module becomes layout width
        return pvModuleDefinition.lengthInMeters();
    }

    @Override
    public double tileLength() {
        // Layout tile is a group of 3 PV modules placed next to each other in a vertical rack
        return 3 * pvModuleDefinition.widthInMeters();
    }

    @Override
    public Stream<PvModulePosition> splitIntoPvModulePositions(LayoutTile layoutTile) {
        return Stream.of(
                // Here the layout tile would be split into 3 individual PvModulePositions
        );
    }
}
