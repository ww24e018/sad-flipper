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

# Builder

The Interface `CommandBuilder` defines and (e.g.) `StandardCommandBuilder` implements
something that calls itself and looks like a Builder(Pattern). It only has one "building"
method defined and does nothing special in the constructor.

When used as a build-and-execute-stack (e.g. in `FL2kEntryTest.testPrintBanners`)
the similarity is possibly more obvious.

It should be, at this stage, already possibly to do hierarchies and ... endless loops (don't though!).

As our tutors mainly used the term for "chainable" Builds I had not concerns
doing a "return yourself" pattern for ease-of-personal-use.

# Mediator

One of the Design-Pattern pages looked like it promised/used some kind of signature-polymorphism
to move switch-statements into method-declarations.

While possible a futile endeavor, doing this kind of thing with a "distinguish objects by giving them
different classes" experiment was temporarily stopped by java conventions and/or my limited
knowledge of how to apply patterns in java or general.

The solution I ended was a little excursion into `java.lang.reflection` 
by way of a web search for "how to cast an object to its own type"
and "quickly" ending up with the command-pattern instance of `InvokeCarefullyCommand`. 
Which is set up to query the actual object types it is given and uses the most specific "notify" signature 
that is found and matches a given situation. 

One looses IDE autocompletion and static analysis capabilities that way, though.

Code got smaller in the refactor, OTOH. 

# Kompositum and Visitor (combined)

After exploring having them separate I decided to do a Compositum pattern where the main operation 
is (only) a visitor-pattern-compatible interface, for a start (so only 2 patterns at once).

Interfaces:
- Component
- Compositum
- ComponentVisitor

An example Visitor doing a tree-structure output print exists in CompTreeTraversalVisitor.

The Classes:
- DebugNoSuchComponent
- DebugNoSuchCompositum
are otherwise "empty" Implementations of leaf- and non-leaf components for the purpose giving the visitor something
basic (and side effect free) to visit and print.

# Other (State and later)

