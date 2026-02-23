reboot of sad-flipper with pre-scaffold version of slm-t3

# Abstract Factory for Banner-Font

in flipper.output.ascii there are interface definitions
for both the factory and a return-interface for the created methods.
`AbstractBannerFactory` with 2 Implementations:
`BannerFactoryFutureFont` and
`BannerFactoryGraffityFont`

In this case one interface for all create methods seemed sufficient.
`AsciiArtStdoutConstructable` assumes print will print via `System.out` 
and defines a constructor that takes a multiline string for configuration.

# Adapter

Feels a liiittle far-fetched atm but `PrintAsciiArtCmd` might be argued as a kind-of an adapter
in that I desired for a command for printing to test the command builder, 
and a simple "wrapper" to call `print` of an AsciiArt-Implementing-Thing seemed 
the simplest ... connection in the context.

