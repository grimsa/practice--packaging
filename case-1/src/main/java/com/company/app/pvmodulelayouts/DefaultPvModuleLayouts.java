package com.company.app.pvmodulelayouts;

import com.company.app.PvModuleDefinition;
import com.company.app.PvModuleLayouts;
import com.company.app.PvModulePosition;
import com.company.app.RoofFace;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class DefaultPvModuleLayouts implements PvModuleLayouts {
    private final BiFunction<RoofFace, PvModuleDefinition, LayoutSpecification> layoutSpecificationConstructor;

    public DefaultPvModuleLayouts(
            BiFunction<RoofFace, PvModuleDefinition, LayoutSpecification> layoutSpecificationConstructor
    ) {
        this.layoutSpecificationConstructor = layoutSpecificationConstructor;
    }

    @Override
    public List<PvModulePosition> optimalLayoutFor(RoofFace roofFace, PvModuleDefinition pvModuleDefinition) {
        var layoutSpecification = layoutSpecificationConstructor.apply(roofFace, pvModuleDefinition);

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
