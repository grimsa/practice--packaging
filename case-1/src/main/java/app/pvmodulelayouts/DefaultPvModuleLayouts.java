package app.pvmodulelayouts;

import app.PvModuleDefinition;
import app.PvModuleLayouts;
import app.PvModulePosition;
import app.RoofFace;
import app.pvmodulelayouts.layoutspecification.PvModulesMountedOnRoofFacePlaneLayoutSpecification;
import app.pvmodulelayouts.layoutspecification.PvModulesMountedOnTiltedRacksLayoutSpecification;

import java.util.List;
import java.util.stream.Stream;

public class DefaultPvModuleLayouts implements PvModuleLayouts {
    @Override
    public List<PvModulePosition> optimalLayoutFor(RoofFace roofFace, PvModuleDefinition pvModuleDefinition) {
        var layoutSpecification = roofFace.slopeAngleInDegrees() < 10
                ? new PvModulesMountedOnRoofFacePlaneLayoutSpecification(pvModuleDefinition)
                : new PvModulesMountedOnTiltedRacksLayoutSpecification(pvModuleDefinition);

        return optimalLayoutTiles(roofFace, layoutSpecification)
                .flatMap(layoutTile -> layoutSpecification.splitIntoPvModulePositions(layoutTile))
                .toList();
    }

    private Stream<LayoutTile> optimalLayoutTiles(RoofFace roofFace, LayoutSpecification layoutSpecification) {
        // Take roof face 2D polygon
        // Take specified layout tile width/height from layout specification
        // Try to pack as many rectangular layout tiles within the roof face polygon
        return Stream.of(
                // assume this is not empty
        );
    }
}
