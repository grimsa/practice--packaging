package com.company.app.pvmodulelayouts;

import com.company.app.PvModuleDefinition;
import com.company.app.PvModuleLayouts;
import com.company.app.PvModulePosition;
import com.company.app.RoofFace;
import com.company.library.variant_a.LibraryVariantAPvModuleLayouts;

import java.util.List;

/**
 * This class adapts {@link LibraryVariantAPvModuleLayouts} (main class of library A) to {@link PvModuleLayouts} (app interface)
 */
public class LibraryVariantACallingPvModuleLayouts implements PvModuleLayouts {
    private final LibraryVariantAPvModuleLayouts delegate = new LibraryVariantAPvModuleLayouts();

    @Override
    public List<PvModulePosition> optimalLayoutFor(RoofFace roofFace, PvModuleDefinition pvModuleDefinition) {
        var libraryRoofFace = new LibraryVariantAPvModuleLayouts.RoofFace(
                roofFace.slopeAngleInDegrees()
        );
        var libraryPvModuleDefinition = new LibraryVariantAPvModuleLayouts.PvModuleDefinition(
                pvModuleDefinition.lengthInMeters(),
                pvModuleDefinition.widthInMeters()
        );
        return delegate.optimalLayoutFor(libraryRoofFace, libraryPvModuleDefinition)
                .stream()
                .<PvModulePosition>map(libraryPvModulePosition -> new PvModulePosition() {
                    // Creating app's PvModulePosition
                })
                .toList();
    }
}
