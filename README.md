Password Manager App(refer to master branch)
====================

A simple and secure password manager application built using Kotlin, Jetpack Compose, Room Database, and Hilt for dependency injection.

Features
--------

-   **Manage Passwords:** Add, update, delete passwords securely.
-   **Swipe Actions:** Swipe-to-delete functionality for managing passwords.
-   **Bottom Sheet:** Add new passwords using a bottom sheet with form validation.
-   **View/Edit Password:** View and edit existing passwords, including account details like username/email and password.
-   **Home Screen:** Display a list of all saved passwords with essential details.
-   **Input Validation:** Ensure mandatory fields are not empty.
-   **Error Handling:** Properly handle errors and edge cases for a smooth user experience.

Setup Instructions
------------------

1.  **Clone the repository:**

    bash

    Copy code

    `git clone https://github.com/SAIF879/PASSWORD-MANAGER.git
    cd password-manager`

2.  **Open in Android Studio:**

    -   Open Android Studio.
    -   Navigate to `File > Open...` and select the cloned directory.
3.  **Run the app:**

    -   Connect your Android device or use an emulator.
    -   Click on the green play button in Android Studio to build and run the app.

Libraries Used
--------------

-   **Jetpack Compose:** Modern UI toolkit for building native Android UI.
-   **Room Database:** Provides an abstraction layer over SQLite to perform database operations.
-   **Hilt:** Dependency injection library for Android that reduces boilerplate code.
-   **Material3:** Compose library for Material Design components and theming.
-   **Kotlin Flows:** Asynchronous data streams with Kotlin.
-   **Version Catalog:** Manage dependencies in a centralized and organized way.

Additional Features
-------------------

-   **Add Password:** Securely add new passwords by providing details such as the account type (e.g., Gmail, Facebook, Instagram), username/email, and password.
-   **Database Security:** Use a secure database (e.g., Room) to manage encrypted passwords locally on the device.
-   **User Interface:** Clean and intuitive UI for managing passwords.

Build Configuration
-------------------

Refer to `build.gradle.toml` for complete details on dependencies and configurations used in the project.





