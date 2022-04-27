# MVVM ShoppingList

ShoppingList: [Source](https://www.youtube.com/playlist?list=PLQkwcJG4YTCT0RouHZ6sQlE4JE6VyD2zO)

## What is MVVM
MVVM stands for Model, View, ViewModel

Repository: a single source of truth for all the data

### <ins>View</ins>

- A part of your app which handles what the user sees and touches on the screen
- A View does all the things an Activity or a Fragment can do
- Views handle only the immediate interaction with the user
- Not putting any business logic like communicating with database
- Only display stuff on screen, do Android specific operation and dispatch user interaction event like click event

### <ins>ViewModel</ins>

- Glue between View and business logic
- Get data from repository and provides to the view
- View have direct reference to ViewModel, so View can observe some data from ViewModel
- Uses **LiveData** which is a handy lifecycle aware library for creating observables

### <ins>Model</ins>

- Where put all the business specific code
- Operate on app's data and fetch it from the local database or from the network
- Repository has a special role of being a mediator between local storage and the server
- ViewModel get data from repository

![image](https://user-images.githubusercontent.com/87624469/165480631-f763085f-2aa4-4b21-8721-9ba0e2d2027d.png)

Article: [Source](https://resocoder.com/2018/08/31/introduction-to-mvvm-on-android/)
