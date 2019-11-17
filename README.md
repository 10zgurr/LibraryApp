# LibraryApp

I have created a sample Android library application that has a local database you can insert, update, delete, and get all data. I have used Kotlin Coroutines library for all these database query processes'. Because for the best performance you don't want to make database queries in the main thread. You should work at the background thread and Kotlin Coroutines library gives you good performance and reliability.

The project built on MVVM architecture with Android Databinding. Also, it has Android Jetpack components and Kotlin language features.

You can learn from this project how to create Room Database and make queries with it. Also, understanding MVVM architecture and Kotlin language. Plus, the usage of Android Data Binding with implementation .xml layout files.

You can also take a look at DiffUtil feature which for updating your adapters' data in a more efficient way.

New Update : I've added the Dagger 2 Dependency Injection mechanism to my project to make the app more efficient and more stable. With this library, it makes a big difference in the big scale Android projects about the app's performance, stability, and reliability.
About the Dagger 2 Dependency Injection : https://github.com/google/dagger


The list of features that my project has:
- Android Data Binding
- Room Persistence Library
- Dagger 2 Dependency Injection
- MVVM Architecture
- Kotlin
- Kotlin Coroutines
- DiffUtil


The list of Android Jetpack components that I have used:
- Room
- Data Binding
- ViewModel
- LiveData
- Lifecycles
