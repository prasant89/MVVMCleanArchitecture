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

    Library Using : Hilt,Flow,Jetpack Componet and Jetpack Compose
