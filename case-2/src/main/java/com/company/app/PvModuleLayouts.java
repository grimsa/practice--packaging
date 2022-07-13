package com.company.app;

import java.util.List;

/**
 * A simple abstraction of a complicated algorithm
 */
public interface PvModuleLayouts {
    List<PvModulePosition> optimalLayoutFor(RoofFace roofFace, PvModuleDefinition pvModuleDefinition);
}
