# TCSS 305 – Group Project: Tetris

**UW Tacoma | Winter 2026**

## Assignment Instructions

Full instructions available at:
[Group Project: Tetris](https://cfb3.github.io/TCSS305-GUIDES/assignments/group-project/)

API Documentation available at:
[Tetris Model API](https://uwt-set-tcss-bryan.github.io/TCSS305-Group-Project/edu/uw/tcss/model/package-summary.html)

## Project Structure

```
src/edu/uw/tcss/
├── app/
│   └── SandBox.java               (sandbox for testing the model API)
├── model/                          (your model classes go here)
└── view/                           (your GUI classes go here)

docs/                               (Tetris model API JavaDoc)

tetris-model-1.0.0.jar              (Tetris model library)
tetris-model-1.0.0-javadoc.jar      (Tetris model JavaDoc archive)

project root/
├── executive-summary.md            (your submission notes)
└── README.md                       (this file)
```

## Getting Started

1. **Explore the model API:**
   - Review the API Documentation linked above
   - Run `SandBox.java` to see the model in action
   - Study `TetrisGame`, `GameControls`, and `GameEvent` classes

2. **Build the GUI:**
   - Create your view classes in `src/edu/uw/tcss/view/`
   - Use `PropertyChangeListener` to listen for `GameEvent` updates from the model
   - Implement the game board, next piece preview, and score display

3. **Connect the model to the view:**
   - Use `PropertyChangeEnabledGameControls` to register listeners
   - Call game control methods (move, rotate, drop) in response to user input

## Running the Application

1. Ensure the `tetris-model-1.0.0.jar` is on your classpath
2. Run your main application class
3. The GUI should display the Tetris game board and controls

## Running Tests

1. Right-click on the `test` folder in IntelliJ
2. Select **Run 'All Tests'**
3. For coverage: Right-click → **Run with Coverage**
