Authors:
1. Piotr Wiatr
2. Adrian Tuta

**Short description of the system:**

The project should create an application showing information about the movement of the International Space Station (ISS).

## The main functions of the system

* Downloading ISS traffic data from the relevant web service
* Processing of downloaded data on the application side
* Downloaded data should be written to the database

## Technologies

* Console application
* JDBC or Hibernate
* Http client, eg HttpClient, OkHttp
* Application presentation layer based on a pattern, eg MVC / MVP
* Domain logic divided into layers, eg DAO, Service
* JSON data serialization / deserialization tool, eg Gson, Jackson
* Unit testing tools
* (Optional) a dependency injection framework, such as Guice
* (Opcjonalnie) (Optional) JavaFX based frontend

## Functionalities

**User Interface**

As part of the console / graphical view, the user should be able to select one of the following options:

* (ISS speed calculation
* (return a list of upcoming ISS runs for a specific location
* (returning the number of people in space within the ISS

## Integration with API

Application functionality should be based on [API:] (http://open-notify.org/Open-Notify-API)


## ISS speed calculation

The user should be informed about the ISS speed based on two readings using [API] (http://open-notify.org/Open-Notify-API). The calculated speed should be saved to the database.

## Returning a list of upcoming ISS runs for a specific location

By selecting this option, the user should be able to see the current list of upcoming ISS runs for a specific location using [API] (http://open-notify.org/Open-Notify-API/ISS-Pass-Times/). Data should be written to the database. The entered location should be validated in accordance with the guidelines described in the documentation.

## Return the number of people in space within the ISS

By selecting this option, the user should be able to see the current list of people in space as part of the space mission, using [API] (http://open-notify.org/Open-Notify-API/People-In-Space/). Data should be written to the database.

## Optional functionalities - TBC

**Statistic data**

The user should be able to calculate, e.g .:

* average speed over a certain period of time, eg month, year. These calculations should be based on the current records from the database
* how many times the ISS has been over a given location in the time interval
* the number of people on the ISS space mission

**visualisation**

As part of the graphical interface, implement a mechanism that displays the current position of the ISS on the world map..

**Data writing / reading**

The user should be able to save the currently collected data to a file in any format, and then restore them by saving directly to the database.

## Unit tests

The implemented functionalities should be covered with unit tests in accordance with commonly used methodologies and practices.

## Additional requirements

The program should meet the following criteria:


