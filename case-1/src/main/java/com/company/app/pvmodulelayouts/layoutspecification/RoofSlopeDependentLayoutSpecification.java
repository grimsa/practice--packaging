package com.company.app.pvmodulelayouts.layoutspecification;

import com.company.app.PvModuleDefinition;
import com.company.app.PvModulePosition;
import com.company.app.RoofFace;
import com.company.app.pvmodulelayouts.LayoutSpecification;
import com.company.app.pvmodulelayouts.LayoutTile;

import java.util.stream.Stream;

public class RoofSlopeDependentLayoutSpecification implements LayoutSpecification {
    private final LayoutSpecification delegate;

    public RoofSlopeDependentLayoutSpecification(RoofFace roofFace, PvModuleDefinition pvModuleDefinition) {
        this.delegate = roofFace.slopeAngleInDegrees() < 10
                ? new PvModulesMountedOnRoofFacePlaneLayoutSpecification(pvModuleDefinition)
                : new PvModulesMountedOnTiltedRacksLayoutSpecification(pvModuleDefinition);
    }

    @Override
    public double tileWidth() {
        return delegate.tileWidth();
    }

    @Override
    public double tileLength() {
        return delegate.tileLength();
    }

    @Override
    public Stream<PvModulePosition> splitIntoPvModulePositions(LayoutTile layoutTile) {
        return delegate.splitIntoPvModulePositions(layoutTile);
    }
}
