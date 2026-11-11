# TCSS 305 – Group Project: Tetris (No AI Agent Track)

**UW Tacoma | Autumn 2026**

## Project Instructions

Full instructions: https://cfb3.github.io/TCSS305-26-AUTUMN/assignments/group-project/tetris/

Each sprint has its own page, linked from there. The sprint pages are the full instructions. This file is only a map of the project.

Back-end API documentation: https://uwt-set-tcss-bryan.github.io/TCSS305-Group-Project

## Project Structure

```
src/edu/uw/tcss/
├── app/
│   └── Sandbox.java                (console demo of the back end)
├── model/                          (empty until Sprint 3, when the back-end source replaces the jar)
└── view/                           (your Swing front end goes here)

docs/                               (back-end API Javadoc, the same pages as the link above)

tetris-model-1.0.0.jar              (the back end, as a library)
tetris-model-1.0.0-javadoc.jar      (the back end's Javadoc, used by IntelliJ)

executive-summary.md                (your team's notes, one section per sprint)
README.md                           (this file)
```

## Running the Application

1. Run `Sandbox.java`.
2. It prints the board after each call it makes to `TetrisGame`. Compare each board with the call that produced it.
