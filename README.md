# Quiz Game Application

## Description

This is a Quiz Game application for Android developed using Java. The game presents multiple-choice questions to the user in a random order each time the app is launched. Users can select answers through buttons on the screen, and their scores are tracked and displayed at the end of each game. The app maintains a list of the top 10 scores, allowing users to enter their name for leaderboard ranking. The app functions offline with questions stored locally using an SQLite database.

## Technologies Used

- **Java:** For implementing the core logic of the Android application.
- **XML:** For designing the user interface layouts.
- **SQLite:** For local data storage of questions and high scores.

## Tools Used

- **Android Studio:** For developing the application.

## Features

1. **Randomized Question Order:**
   - The app randomly shuffles the order of questions each time the game starts, ensuring a unique experience in every session.

2. **Multiple Choice Questions:**
   - Each question is displayed with four options. The user selects one as their answer.

3. **Score Tracking:**
   - After completing the quiz, the user's score is displayed and can be saved with their name in the top 10 scores.

4. **Top 10 Scores:**
   - Displays a leaderboard of the top 10 scores, allowing users to compare their performance.

5. **Offline Functionality:**
   - The app does not require an internet connection to function as all data is stored locally.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Android Studio Installed:** Make sure you have the latest version of [Android Studio](https://developer.android.com/studio) installed.
- **Java Development Kit (JDK):** Ensure you have JDK 8 or later installed on your system.
- **Git:** Ensure Git is installed to clone the project repository, or download the project as a ZIP file if you prefer not to use Git.
- **Android Emulator:** Set up an Android emulator in Android Studio for testing.

## How to Run

Follow these steps to set up and run the application:

**1. Clone the Repository**

Get the project files on your local machine using Git or download the project as a ZIP file.

- **Using Git:**
  - Open a terminal or command prompt and execute the following command:
    ```bash
    git clone https://github.com/nikolaoskor/quiz-app.git
    ```

- **Download ZIP:**
  - Go to the repository page on GitHub, click on the "Code" button, and select "Download ZIP."
  - Extract the ZIP file to your desired location.

**2. Open in Android Studio**

- Launch Android Studio and open the project folder you cloned or extracted.
- Allow the IDE to index the project and download any necessary dependencies.

**3. Set Up an Emulator**

- Open the **Device Manager** and create a new virtual device if you haven't already.
- Select a device definition and system image to configure the emulator.

**4. Build the Project**

- Ensure your emulator is running, then build the project to verify everything is set up correctly.

**5. Run the Application**

- Execute the application on the emulator to install and launch it.
