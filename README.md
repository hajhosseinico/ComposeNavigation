# Compose Navigation App

<div align="center">
    <img src="https://github.com/user-attachments/assets/f91e6841-7c4c-4fbb-bc28-c074b9ed6ce9" width="300">
  <img src="https://github.com/user-attachments/assets/15e280a5-151e-4f6e-9055-12268ee9d747" width="300">
  <img src="https://github.com/user-attachments/assets/5a074a8d-66a9-4fa4-91dc-c18d4a2c7f09" width="300">
</div>

# 
**Compose Navigation App** is a simplified Android application built using **Jetpack Compose** for seamless and intuitive navigation. The app is designed to showcase the use of **type-safe navigation** between screens in Compose, ensuring smooth transitions and a declarative approach to UI development.

## 🚀 Features

- **Type-Safe Navigation**: Ensures that all navigation between screens is type-safe, making the code easier to maintain and less prone to runtime errors.
- **Jetpack Compose UI**: Entirely built using Jetpack Compose, this app leverages declarative UI to simplify view management.
- **Kotlin Serialization**: Easy data transfer between screens with Kotlin's `@Serializable` annotation.
- **Back Stack Management**: Smooth control over navigation actions with appropriate back stack handling.
- **Clean Code Structure**: Emphasizes clean, maintainable, and scalable architecture for Android applications.
  
## 📱 Technologies and Libraries

### Core Libraries

- **Jetpack Compose**: Modern UI toolkit for declarative UI in Android.
- **AndroidX Navigation**: Navigation components specifically designed for Compose.
- **Kotlinx Serialization**: Handles data serialization between screens.

### Navigation

- **Type-Safe Navigation**: Navigate between composables using type-safe data models.

### Architecture

- **ViewModel**: Handles state management across multiple screens.
- **State Handling**: Uses `remember` and `mutableStateOf` for managing UI states within composables.
  
### UI Components

- **Material Design 3**: Consistent and modern UI elements.
- **LazyColumn**: Efficient list handling with Jetpack Compose’s scrolling mechanism.
  
## 🛠️ Build Setup

### Clone the Repository

```bash
git clone https://github.com/hajhosseinico/ComposeNavigation.git
cd ComposeNavigation
```

### Setup Dependencies

Open the project in Android Studio and let it sync the dependencies automatically.

### Build and Run

Select a device or emulator and click the **Run** button in Android Studio.

## 🧩 Project Architecture

The app follows a clean separation of concerns, with the UI layer built entirely in **Jetpack Compose** and the navigation logic handled in a structured, type-safe manner. Here’s a brief overview of the components:

1. **Presentation Layer**: UI built with Jetpack Compose, handling user interactions and state.
2. **ViewModel Layer**: Holds and manages UI-related data to ensure it survives configuration changes.
3. **Data Transfer**: Type-safe transfer of data between composable functions using Kotlin's serialization.

The project follows **test-driven development (TDD)** principles, with a focus on both UI and logic testing. Here’s an overview of the testing approach:

- **Unit Tests**: Ensure ViewModels and navigation logic are correctly implemented.
- **UI Tests**: Validate UI components using Compose’s testing framework.
  
## 📚 Libraries and Dependencies

- **Jetpack Compose** for UI and state management.
- **Kotlinx Serialization** for safe data passing between screens.
- **Material Design 3** for modern UI components.
- **JUnit** and **MockK** for testing.

For more details on the dependencies, refer to the `build.gradle` file.

## 👨‍💻 Contribution

Contributions are welcome! Feel free to open an issue or submit a pull request. Please ensure your code adheres to the project's coding style and passes all tests.

## 📄 License

This project is open-source and free to use, modify, and distribute. Created to help developers better understand and implement navigation in Jetpack Compose.

## 📬 Contact

For any questions, suggestions, or feedback, feel free to reach out!

- **Author**: Ali Hajhosseini
- **Email**: [hajhosseinico@gmail.com](mailto:hajhosseinico@gmail.com)
- **GitHub**: [hajhosseinico](https://github.com/hajhosseinico)

---

Feel free to modify this readme according to any specific needs for your project!
