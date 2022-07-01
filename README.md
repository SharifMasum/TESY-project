# API FOR TESY-DEMO APP

#The animal class have following properties:
  String tesyId;
  LocalDate dateOfArrival (format YYYY-MM-DD);
  String fromWhere;
  String animal;
  String name;
  String typeOfAnimal;
  String color;
  String sex;
  String situation;
  LocalDate dateOfDeparture (accepts format YYYY-MM-DD);
  String chipNumber;
  String note;

#GET REQUEST
 The GET request to fetch all the animals in the database is url/api/animal
 The GET request to fetch one specific animal is url/api/animal/${ID}
 If the animal with the given ID doesn't exist, it will throw an error with status 500 and message "The animal with the given ID doesn't exist".

#POST REQUEST
 The POST requests needs to be sent to the following API: url/api/animal.
 It accepts one object, no array of Objects, just one JSON format object.
 Ex.
 {"tesyId":"29065/22","dateOfArrival":"2022-06-29","fromWhere":"Mynämäki","animal":"cat","name":"Petra","typeOfAnimal":"cat","color":"blue","sex":"male","situation":"Very bad","dateOfDeparture":"2022-12-12","chipNumber":"53dls","note":"She is in very bad situation"}
 Specify the dates in this format YYYY-MM-DD, otherwise it will return an error.
 None of of the properties are required, and if you don't specify a property, will add "null".
 The database will add an "id" property to every JSON item.

#DELETE REQUEST
 The DELETE request needs to be sent to following API: url/api/animal/${id} as a DELETE request.
 If the animal with the given ID doesn't exist, it will throw an error with status 500 and message "The animal with the given ID doesn't exist".

#PUT REQUEST
 For editing the data you will need to sent a PUT request, in the following format:
 url/api/animal/${id}?name=${newName}&situation=${newSituation}
 Ex.
 https://tesy-demo.herokuapp.com/api/animal/6?name=Pero&situation=Very bad situation, life is terrible
 the example above, will change the item with the ID 6. It will change it's name to "Pero" and the property situation to "Very bad situation, life is terrible"

 !!!STILL IT'S NOT POSSIBLE TO CHANGE THE DATES!!!


#USING THE APP ON YOUR LOCAL MACHINE
 Currently the app is configured to connect to the remote Heroku PostgreSQL database from Heroku account. Before using it, please change this in
 src>main>resources>application.properties
 You will need to install PostgreSQL and Java 17 installed on your computer to be able to run this project locally.