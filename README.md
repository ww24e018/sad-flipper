reboot of sad-flipper with pre-scaffold version of slm-t3

See bottom for a list or work-not-done.

Run a interactive flipper2k simulation by running `main` in `FL2kEntryTest` (if you want).

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

# State

There is a MachineRunState.

# Run loop

`SuperPinballMachine2000` has a `public void runLoopSimulation()` method.
The `switch()` in there I find interesting in that it first
- does a roundabout into Button subclass to simulate a press 
- which uses java.lang.reflect to invoke a method in its meditor (the `SuperPinballMachine2000` itself) 
- with the more specific subclass it has
- which is only a few lines up in the code.

That roundabout then calls into the `machineState` which, depending on which kind of state is 
referenced at that time, 
- might only write an output *OR*
- call an object with lots of implemented interfaces to invoke a constructed-at-construction chain-command, consisting of
  - a command writing to stdout
  - a command waiting a few milliseconds
  - a command writing something else to stdout.

At which point deadlines demanded finalizing the README.md

# "TODO"

Unimplemented ATM: 
- Leaving the playing state by simulating a ball-entering-sink event.
- A component tree that simulates lights and noice and animated blinkenlights.
- Removing the (deprecated) `SuperPinballMachine2000InputMediator` implementation
- Refactoring Button in the direction of being an interface
- ...


