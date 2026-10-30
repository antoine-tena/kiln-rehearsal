# kiln rehearsal

A small repo kiln's CI updates on every release branch, before any real repo.

<!-- This file belongs to the project: kiln wrote it once and never changes it. kiln's rules live
in .claude/rules/kiln/ and are kept current by `kiln update`. Write here what Claude cannot
guess about this project, and keep it under 200 lines: every session reads it. -->

## Repo map

Where to look, so as not to explore: read it before opening files, and update it in the commit
that adds, moves or removes a directory, a domain or an entry point. One line per place, what
it holds; no copy of the code.

- `backend/src/main/java/fr/kilnrehearsal/`: entry point (`Main.java`), one
  package per domain; `backend/src/test/java/`: JUnit tests; `backend/pom.xml`: Maven build.
- `docs/backlog/`: the work to do; `charter.toml`: the checked rules; `.claude/rules/kiln/`:
  kiln's rules for Claude.

## Notes

<!-- Decisions, conventions and pitfalls of this project that Claude cannot guess from the code:
"we never call X directly, always through Y", "the staging database is reset every night"… -->

## Carried over from the instructions of kiln 0.3

### From `CLAUDE.md`

#### Notes du projet

- Un trajet a au moins une place ; la réservation ne dépasse jamais la capacité (`Seats`).
