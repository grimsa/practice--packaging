package com.company.app.pvmodulelayouts;

import com.company.app.PvModulePosition;

import java.util.stream.Stream;

public interface LayoutSpecification {
    double tileWidth();

    double tileLength();

    Stream<PvModulePosition> splitIntoPvModulePositions(LayoutTile layoutTile);
}
