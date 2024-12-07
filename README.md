Project Structure
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

Libraries used: Hilt, Flow, Jetpack Component, and Jetpack Compose.

Here's a polished version of the description:

<super>
1)Login Screen: Implements basic input fields with empty-field validation and a password toggle for secure entry.
2)Registration Screen: Includes simple input fields with empty-field validation to ensure completeness before submission.
3)Enhanced UI: Features icons for input fields and a password visibility toggle for better user experience.
4)State Management: Utilizes a ViewModel to manage input field states, button click events, and navigation between screens.
5)Nested Navigation: Demonstrates seamless handling of two navigation flows: one for unauthenticated users (e.g., login and registration) and another for authenticated users (e.g., dashboard).
This concise description highlights the app's features while emphasizing its structured and efficient implementation.</supe>


Added Screen Short:

For LogIn :
![Screenshot_20241206_011733](https://github.com/user-attachments/assets/a755ce3a-cd20-4fbd-89c5-87031af083e5)

For Register:
![Screenshot_20241206_011808](https://github.com/user-attachments/assets/c38daf57-74b9-4678-a3eb-9ae1baccc25e)


