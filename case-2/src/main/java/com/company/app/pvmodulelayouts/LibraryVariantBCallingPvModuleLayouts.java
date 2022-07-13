package com.company.app.pvmodulelayouts;

import com.company.app.PvModuleDefinition;
import com.company.app.PvModuleLayouts;
import com.company.app.PvModulePosition;
import com.company.app.RoofFace;
import com.company.library.variant_b.LibraryVariantBPvModuleLayouts;

import java.util.List;

/**
 * This class adapts {@link LibraryVariantBPvModuleLayouts} (main class of library B) to {@link PvModuleLayouts} (app interface)
 */
public class LibraryVariantBCallingPvModuleLayouts implements PvModuleLayouts {
    private final LibraryVariantBPvModuleLayouts delegate = new LibraryVariantBPvModuleLayouts();

    @Override
    public List<PvModulePosition> optimalLayoutFor(RoofFace roofFace, PvModuleDefinition pvModuleDefinition) {
        var libraryRoofFace = new ToLibraryRoofFaceAdapter(roofFace);
        var libraryPvModuleDefinition = new ToLibraryPvModulDefinitionAdapter(pvModuleDefinition);
        return delegate.optimalLayoutFor(libraryRoofFace, libraryPvModuleDefinition).stream()
                .<PvModulePosition>map(libraryPvModulePosition -> new FromLibraryPvModulePositionAdapter(libraryPvModulePosition))
                .toList();
    }

    private static class ToLibraryRoofFaceAdapter implements LibraryVariantBPvModuleLayouts.RoofFace {
        private final RoofFace adaptee;

        private ToLibraryRoofFaceAdapter(RoofFace adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public double slopeAngleInDegrees() {
            return adaptee.slopeAngleInDegrees();
        }
    }

    private static class ToLibraryPvModulDefinitionAdapter implements LibraryVariantBPvModuleLayouts.PvModuleDefinition {
        private final PvModuleDefinition adaptee;

        public ToLibraryPvModulDefinitionAdapter(PvModuleDefinition adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public double lengthInMeters() {
            return adaptee.lengthInMeters();
        }

        @Override
        public double widthInMeters() {
            return adaptee.widthInMeters();
        }
    }

    private static class FromLibraryPvModulePositionAdapter implements PvModulePosition {
        private final LibraryVariantBPvModuleLayouts.PvModulePosition adaptee;

        private FromLibraryPvModulePositionAdapter(LibraryVariantBPvModuleLayouts.PvModulePosition adaptee) {
            this.adaptee = adaptee;
        }
    }
}
