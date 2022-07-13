### Overview

This example is similar to `case-1`, except the situation modeled here is the following:

- In `case-1` we had `PvModuleLayouts` abstraction, the implementation of which was isolated in a single subtree of the package hierarchy
- Let's assume the implementation of `PvModuleLayouts` is complex, has a long-running test suite, and changes rarely
- Naturally, we would consider extracting the implementation out of the application codebase (in this case - into a Java library)

While normally there would be a separate project for the library (building which would produce a JAR file that the app would depend on),
here I simply moved the classes into a `com.company.library` package.

Discussion thread: [Implications of extracting a library](https://github.com/grimsa/practice--packaging/discussions/2)