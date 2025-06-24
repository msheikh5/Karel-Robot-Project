# Karel Robot - Map Division Project

A Java-based Karel robot implementation that intelligently divides rectangular maps into equal chambers using optimal pathfinding algorithms.

## 📋 Project Overview

Karel is a simple robot that can navigate within a rectangular grid world. This project implements an algorithm to divide any given map into 4 equal chambers (or the maximum possible number of equal chambers for smaller maps) using beepers as dividers.

## 🎯 Objective

The main task is to divide a given map into 4 equal chambers, taking into consideration special cases such as:
- Small maps that can't be divided into 4 equal chambers
- Maps with odd dimensions
- Edge cases with very small dimensions (≤2)

## 🔧 Features

- **Intelligent Map Analysis**: Automatically calculates map dimensions
- **Optimal Pathfinding**: Uses zig-zag methodology to minimize steps
- **Special Case Handling**: Manages edge cases for small and irregular maps
- **Step Counter**: Tracks and reports the number of steps taken
- **Flexible Chamber Division**: Adapts to different map sizes and shapes

## 🚀 How It Works

### Core Components

1. **Map Dimension Calculation**: Karel determines the width and height of the map
2. **Chamber Division Strategy**: Based on map dimensions, chooses appropriate division method
3. **Beeper Placement**: Places beepers strategically to create equal chambers
4. **Path Optimization**: Uses efficient movement patterns to reduce total steps

### Algorithm Flow

```
Start → Calculate Map Dimensions → Determine Division Strategy → Execute Division → Count Steps
```

## 📊 Division Strategies

### Normal Case (Width > 2 AND Height > 2)
- **Both Even**: Uses `evenMap()` for both dimensions
- **Both Odd**: Uses `oddMap()` for both dimensions  
- **Mixed**: Combines even and odd map strategies

### Special Cases (Width ≤ 2 OR Height ≤ 2)
- Determines the larger dimension and applies specialized division algorithms
- Uses mathematical formulas to optimize beeper placement
- Handles edge cases like 2x2 maps with diagonal division

### Movement Patterns

#### Even Maps
- Moves to middle position: `(dimension/2) - 1` steps
- Uses zig-zag pattern for efficient coverage
- Places beepers in two parallel lines

#### Odd Maps  
- Moves to center position: `dimension/2` steps
- Places beepers in single center line
- Simpler linear movement pattern

## 🏗️ Code Structure

### Key Methods

- `run()`: Main execution method
- `calculateWidthAndHeight()`: Determines map dimensions
- `normalCase()`: Handles standard map sizes
- `evenMap()`: Divides even-dimensioned sides
- `oddMap()`: Divides odd-dimensioned sides
- `specialCase()`: Manages edge cases for small maps
- `moveAndCount()`: Optimized movement with step counting

### Variables

- `width`: Map width dimension
- `height`: Map height dimension  
- `counter`: Total steps taken by Karel

## 📈 Performance

The algorithm is optimized for minimal steps using:
- Zig-zag movement patterns where applicable
- Strategic turning to avoid unnecessary movements
- Efficient beeper placement algorithms

## 🎮 Usage

1. Load the Karel environment
2. Set up your desired map configuration
3. Run the program
4. Karel will automatically:
   - Analyze the map
   - Choose the optimal division strategy
   - Execute the chamber division
   - Report the total steps taken

## 📸 Example Results

The algorithm successfully handles various map configurations:
- Large rectangular maps (10x10, 14x1, etc.)
- Small square maps (2x2, 3x3)
- Irregular dimensions with mixed even/odd sizes

## 👨‍💻 Author

**Mohammad Alsheikh**  
Email: Malialsheikh2001@gmail.com

## 🏢 Organization

Atypon Training

## 🔍 Technical Details

- **Language**: Java
- **Platform**: Karel Robot Environment
- **Algorithm Complexity**: Optimized for minimal step count
- **Special Features**: Handles edge cases and irregular map dimensions

## 📝 Notes

This implementation focuses on generalization and path optimization, ensuring the solution works for any map configuration while minimizing the number of steps required for completion.
