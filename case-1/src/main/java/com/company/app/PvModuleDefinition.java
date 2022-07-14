package com.company.app;

/**
 * Defined attributes common to all instances of physical PV modules (think manufacturer-published datasheet of a specific PV module product)
 */
public interface PvModuleDefinition {
    double widthInMeters();

    double lengthInMeters();
}
