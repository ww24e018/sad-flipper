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



