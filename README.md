# Logger - Keystroke Dynamics Analysis

## Overview

**Logger** is a Java-based application designed to capture and analyze keystroke dynamics. By recording unique keystroke patterns as individuals type a given sentence, this application enables the extraction of key features that can contribute to the early detection and prediction of common mental disorders through digital phenotyping.

## Features

- **Keystroke Timing and Frequency**: The application records three primary types of keystroke features for each set of key presses:
  1. **Hold Period (Dwell Time)**: The duration a key is pressed.
  2. **Down-Down Time**: The time between pressing one key and pressing the next key.
  3. **Up-Down Time (Latency)**: The time between releasing one key and pressing the next key.

- **Data Collection**: Keystroke patterns are recorded for each individual typing the provided sentence. The data is stored in a CSV or Excel file, with each row representing the keystroke dynamics of one participant.

- **Psychomotor Impairment and Digital Phenotyping**: This application plays a crucial role in the process of identifying and predicting common mental disorders by leveraging keystroke data as digital phenotypes. Psychomotor impairment, which refers to the disruption of the connection between mental and muscle functions, is linked to mental health conditions. By analyzing keystroke dynamics, we can gain insights into these impairments.

## Installation

1. **Compile Java Files**: 
   ```sh
   javac *.java
   ```

2. **Create JAR File**:
   ```sh
   jar cfm logger.jar manifest.mf *.class
   ```

## Usage

1. Open the `logger.jar` file using JDK.
2. Follow the on-screen instructions to read and type the provided sentence.
3. Press "Enter" once you finish typing the sentence.
4. The application will automatically record your keystroke patterns and save them in a CSV or Excel file.

## Applications

- **Research**: Utilize the recorded keystroke data for research in digital phenotyping and psychomotor impairment.
- **Mental Health Diagnostics**: Develop models that predict common mental disorders based on keystroke dynamics.

## Contribution

Contributions to this project are welcome. Feel free to submit issues or pull requests on GitHub.
