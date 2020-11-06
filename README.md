# Java Developer Homework

Hi! I'm your first Markdown file in **StackEdit**. If you want to learn about StackEdit, you can read me. If you want to play with Markdown, you can edit me. Once you have finished with me, you can create new files by opening the **file explorer** on the left corner of the navigation bar.

## API #1
Description: This api outputs the weather information of the city name provided

Endpoint: `<host>/hc-homework/weather-info/location`

Method: POST

Request Body:

    {
	     "location" : String
    }

Response Body:

    {
	    "location" : String,
	    "actualWeather" : String,
	    "temperature" : String (in celsius)
    }

This api also saves the fetched weather information in a database (i used mysql)
| Table Columns | Description |
|--|--|
| id | Unique id |
| location| City name (string) |
| actualWeather | String |
| temperature| String |
| dtimeInserted| Timestamp in UTC|

## API #2
Description: This api outputs the last 5 weather info record

Endpoint:  `<host>/hc-homework/weather-info/latest-5`

Method: GET

Response Body:

	[
		{
			"location" : String,
			"actualWeather" : String,
			"temperature" : String (in celsius)
		}
    ]
