package app.pvmodulelayouts;

import app.PvModulePosition;

import java.util.stream.Stream;

public interface LayoutSpecification {
    double tileWidth();

    double tileLength();

    Stream<PvModulePosition> splitIntoPvModulePositions(LayoutTile layoutTile);
}
