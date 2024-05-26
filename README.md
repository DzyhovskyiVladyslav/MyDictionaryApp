# SPEC-1: My Dictionary App

## Table of Contents
- [Background](#background)
- [Requirements](#requirements)
- [Method](#method)
  - [Architecture Overview](#architecture-overview)
  - [Database Schema](#database-schema)
  - [Component Diagram](#component-diagram)
  - [Key Functionalities](#key-functionalities)
- [Implementation](#implementation)
  - [Step 1: Set Up Development Environment](#step-1-set-up-development-environment)
  - [Step 2: Define the Project Structure](#step-2-define-the-project-structure)
  - [Step 3: Implement Database Layer](#step-3-implement-database-layer)
  - [Step 4: Implement Repository Layer](#step-4-implement-repository-layer)
  - [Step 5: Implement ViewModel Layer](#step-5-implement-viewmodel-layer)
  - [Step 6: Implement UI Layer](#step-6-implement-ui-layer)
  - [Step 7: Implement Additional Features](#step-7-implement-additional-features)
  - [Step 8: Testing and Debugging](#step-8-testing-and-debugging)
  - [Step 9: Prepare for Release](#step-9-prepare-for-release)
  - [Step 10: Release and Post-Release](#step-10-release-and-post-release)
- [Milestones](#milestones)
- [Gathering Results](#gathering-results)

## Background

The primary purpose of this app is to allow users to create personalized dictionaries for storing word translations between two languages. These dictionaries can be divided into various topics. The app is intended for individuals who are learning new languages and want a convenient way to store and review translations. The app will be developed for Android and will be available on the Google Play Store. The app will be developed using Java for the Android platform, and GitHub will be used for version control.

## Requirements

**Must Have**
1. **Dictionary Management**
   - Users must be able to create and manage multiple dictionaries.
   - Each dictionary must be linked to two languages (e.g., German - English).

2. **Topic Management**
   - Users must be able to create and manage multiple topics within each dictionary.

3. **Word and Translation Management**
   - Users must be able to add, view, edit, and delete words and their translations within each topic.
   - Words and translations must be displayed in a list format.

4. **Search Functionality**
   - Users must be able to search for words within a dictionary.

5. **Offline Access**
   - Users must be able to access their dictionaries and translations offline.

**Should Have**
1. **User Interface**
   - The app should have a user-friendly and intuitive interface.
   - Dark mode support should be available.

**Could Have**
1. **Export/Import Functionality**
   - Users could export their dictionaries to a file and import them back.

**Won't Have**
1. **User Authentication**
   - The app won't include user authentication.
   
2. **Synchronization**
   - The app won't include synchronization across devices.

3. **Notifications**
   - The app won't include notifications.

4. **Sharing**
   - The app won't include sharing dictionaries or topics.

5. **Statistics**
   - The app won't include statistics on user progress.

## Method

### Architecture Overview

The "My Dictionary" app will follow a modular architecture, ensuring separation of concerns and scalability. The key components of the architecture include:

1. **UI Layer**: Responsible for the user interface and user interactions.
2. **Domain Layer**: Contains the business logic of the application.
3. **Data Layer**: Manages data storage and retrieval.

We will use the Model-View-ViewModel (MVVM) pattern to facilitate a clean separation between the UI and the business logic.

### Database Schema

We will use SQLite for local storage. The database schema will consist of three main tables: `Dictionary`, `Topic`, and `Word`.

```sql
CREATE TABLE Dictionary (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    language_from TEXT NOT NULL,
    language_to TEXT NOT NULL
);

CREATE TABLE Topic (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    dictionary_id INTEGER NOT NULL,
    name TEXT NOT NULL,
    FOREIGN KEY(dictionary_id) REFERENCES Dictionary(id)
);

CREATE TABLE Word (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    topic_id INTEGER NOT NULL,
    word TEXT NOT NULL,
    translation TEXT NOT NULL,
    FOREIGN KEY(topic_id) REFERENCES Topic(id)
);
```

### Component Diagram

![Component Diagram](https://www.plantuml.com/plantuml/png/TP3DIiKm48NtynJXxkyho1MwKB0RyMSXBiPsa63QX3HLYlZkLaLd9cEwwvd3zuLpMWhciau14Wul-4pkS7lfhd2ZV73luFRleKS_dm_5l_goFVv4dT__uunvgmutCVcXokvZ7Zdw05PrSThPhAlOTvxU-ZXIa70EcSwPncF19loQKbnyYLazdLE1D-4N-0aNkg2GA7zBvKZkU3npTY9G4JVLPi1_ltUvNriazxAcTjNwzCp0Ul4UFiC_K9PLKuDciqvK5FvFA0gWvs_ARC_8RCNOJZIFwnG-0G00)

### Key Functionalities

1. **Create and Manage Dictionaries**
   - **UI**: Forms to create new dictionaries and list existing ones.
   - **Logic**: Validation of dictionary names and language pairs.
   - **Storage**: Insert new dictionary records into the `Dictionary` table.

2. **Create and Manage Topics**
   - **UI**: Forms to create new topics and list existing ones within a dictionary.
   - **Logic**: Validation of topic names.
   - **Storage**: Insert new topic records into the `Topic` table.

3. **Add, View, Edit, and Delete Words and Translations**
   - **UI**: Forms to add new words, list words in a topic, and edit/delete options.
   - **Logic**: Validation of word and translation entries.
   - **Storage**: CRUD operations on the `Word` table.

4. **Search Functionality**
   - **UI**: Search bar to input search terms.
   - **Logic**: Query the `Word` table for matches.
   - **Storage**: Retrieve and display search results.

## Implementation

### Step 1: Set Up Development Environment
1. **Install Android Studio**: Ensure the latest version of Android Studio is installed.
2. **Create a New Project**: Set up a new Android project with an appropriate package name.
3. **Set Up GitHub Repository**: Initialize a GitHub repository and connect it to the Android project.

### Step 2: Define the Project Structure
1. **Create Packages**: Organize the project into packages for UI, ViewModels, Repositories, and Models.
2. **Add Dependencies**: Update `build.gradle` files to include necessary libraries like Room for SQLite, LiveData, and ViewModel.

### Step 3: Implement Database Layer
1. **Define Entities**: Create data classes for `Dictionary`, `Topic`, and `Word`.
2. **Create DAOs**: Define Data Access Objects (DAOs) for CRUD operations.
3. **Set Up Room Database**: Configure the Room database to include the entities and DAOs.

### Step 4: Implement Repository Layer
1. **Create Repositories**: Implement repositories for `Dictionary`, `Topic`, and `Word` to interact with the DAOs.
2. **Add Business Logic**: Ensure repositories handle any necessary business logic before data operations.

### Step 5: Implement ViewModel Layer
1. **Create ViewModels**: Implement ViewModels for `Dictionary`, `Topic`, and `Word`.
2. **Integrate LiveData**: Use LiveData to manage and observe data changes.

### Step 6: Implement UI Layer
1. **MainActivity**: Create the main activity to navigate between dictionaries.
2. **DictionaryActivity**: Implement activity to list and manage dictionaries.
3. **TopicActivity**: Implement activity to list and manage topics within a dictionary.
4. **WordActivity**: Implement activity to add, view, edit, and delete words and their translations.

### Step 7: Implement Additional Features
1. **Search Functionality**: Add search functionality in `WordActivity`.
2. **Dark Mode Support**: Implement dark mode support across the app.

### Step 8: Testing and Debugging
1. **Unit Tests**: Write unit tests for ViewModels and Repositories.
2. **UI Tests**: Implement UI tests to ensure smooth navigation and functionality.
3. **Debugging**: Test the app on different devices and screen sizes, and fix any bugs.

### Step 9: Prepare for Release
1. **Create App Icons**: Design and add app icons for different screen resolutions.
2. **Write Documentation**: Prepare user documentation and a README file for the GitHub repository.
3. **Play Store Listing**: Prepare screenshots, a description, and other necessary details for the Play Store listing.

### Step 10: Release and Post-Release
1. **Deploy to Play Store**: Follow the guidelines to upload and publish the app on the Play Store.
2. **Monitor Feedback**: Collect user feedback and monitor crash reports.
3. **Plan Updates**: Plan and implement future updates based on user feedback and feature requests.

## Milestones

1. **Development Environment Setup**: Complete within the first week.
2. **Database Layer Implementation**: Complete within the second week.
3. **Repository and ViewModel Layers Implementation**: Complete within the third week.
4. **UI Layer Implementation**: Complete within the fourth week.
5. **Additional Features Implementation**: Complete within the fifth week.
6. **Testing and Debugging**: Complete within the sixth week.
7. **Prepare for Release**: Complete within the seventh week.
8. **Release on Play Store**: Complete within the eighth week.

## Gathering Results

1. **User Feedback**: Collect and analyze feedback from users to identify areas for improvement.
2. **App Performance**: Monitor app performance and fix any issues to ensure a smooth user experience.
3. **Feature Utilization**: Track which features are most used to guide future development priorities.
4. **Crash Reports**: Regularly check and address any crash reports to maintain app stability.