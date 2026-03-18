# MeApp — Simple

An Android application built to demonstrate Clean Architecture and MVI on a single-module setup. A multi-module version of this project also exists, where each feature and layer is a separate Gradle module.

---

## Architecture

The project follows Clean Architecture with strict layer separation across every feature.

```
presentation  →  domain  ←  data
```

- **Presentation** — ViewModels, UI state, Compose screens.
- **Domain** — Use cases, repository interfaces, domain models.
- **Data** — Repository implementations, network and database sources, mappers. Hidden behind the repository interface.

### MVI

State management follows a unidirectional MVI pattern built on a shared `BaseViewModel`:

```
User event → Action → reduce(currentState) → new State → UI
```

Each `Action` is a pure function that takes the current state and returns the next one. Duplicate states are deduplicated before emission — the UI only receives a new state when something actually changed. A `StateTimeTravelDebugger` logs every action and state transition in debug builds.

### Result type

Errors propagate through layers via a sealed `Result<T>`:

```kotlin
sealed interface Result<out T> {
    data class Success<T>(val value: T) : Result<T>
    data class Failure(val throwable: Throwable? = null) : Result<Nothing>
}
```

The data layer produces it. The domain layer transforms it. The presentation layer consumes it. Nothing leaks across boundaries.

---

## Features

### Albums
Searches albums via the Last.fm API (XML). Results are cached to a local Room database. On a network failure the repository falls back to the cached data silently, so the screen remains usable offline. Albums can be marked as favourites, which is persisted locally.

### Live Feed
Fetches and displays an RSS feed. Each item opens a detail screen with the full content. Navigation arguments are serialised into the route so they survive process death.

### Birthdays
A local-only birthday tracker. Add a birthday with a date picker, view the list sorted by upcoming date.

---

## Tech Stack

| Concern | Library |
|---|---|
| UI | Jetpack Compose, Material 3 |
| Navigation | Navigation Compose (type-safe, serialised routes) |
| State | Kotlin Coroutines, StateFlow |
| Dependency injection | Koin |
| Network | Retrofit, OkHttp, TikXml (XML), Kotlinx Serialization (JSON) |
| Local storage | Room |
| Image loading | Coil |
| Animations | Lottie |
| Logging | Timber |
| Static analysis | Detekt, Spotless / ktlint, Konsist |
| Testing | JUnit 5, MockK, Kluent, Konsist |

---

## Static Analysis & Architecture Tests

The project uses [Konsist](https://github.com/LemonAppDev/konsist) to enforce architecture rules as automated tests — verifying layer boundaries, naming conventions, and dependency direction at build time rather than in code review.

Detekt and Spotless (ktlint) run on every build to enforce code style and catch common issues.

---

## Claude Code Setup

The project is configured for expansion with [Claude Code](https://claude.ai/code). A set of domain-specific skills covering areas like architecture, state, navigation, and testing are defined in `.claude/skills/`.

The skills are written as engineering principles — the kind that come from experience and carry a point of view — rather than lists of instructions. This means Claude reasons from understanding rather than executing steps, and produces code that fits the existing architecture instead of code that merely compiles.

