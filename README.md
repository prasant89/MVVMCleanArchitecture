# Android Clean Architecture - Login Page

## Libraries Used

- Hilt
- Flow
- Jetpack Components
- Jetpack Compose

## Features

1. **Login Screen**: Implements input fields with validation for empty fields and a toggle for password visibility.
2. **Registration Screen**: This screen contains input fields with validation to ensure that all required fields are filled before submission.
3. **Enhanced UI**: This version incorporates icons for input fields and a password visibility toggle to improve user experience.
4. **State Management**: This method utilizes a ViewModel to handle input states, button clicks, and navigation between screens.
5. **Nested Navigation**: Demonstrates smooth navigation for unauthenticated users (e.g., login and registration) and authenticated users (e.g., dashboard).

## Screenshots

**Login Screen:**
![Login Screen](https://github.com/user-attachments/assets/a755ce3a-cd20-4fbd-89c5-87031af083e5)

**Registration Screen:**
![Registration Screen](https://github.com/user-attachments/assets/c38daf57-74b9-4678-a3eb-9ae1baccc25e)


## Project Structure

```text
app/
├── data/
│   ├── repository/
│   │   └── UserRepositoryImpl.kt
│   ├── models/
│   │   └── User.kt
│   └── local/
│       └── UserDao.kt
├── domain/
│   ├── repository/
│   │   └── UserRepository.kt
│   └── usecases/
│       └── GetUsersUseCase.kt
├── presentation/
│   ├── viewmodels/
│   │   └── UserViewModel.kt
│   └── screens/
│       └── UserScreen.kt
└── di/
    └── AppModule.kt



This concise description highlights the app's features while emphasizing its structured and efficient implementation.
