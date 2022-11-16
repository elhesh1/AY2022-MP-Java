package edu.illinois.cs.cs124.ay2022.mp.models;

import java.util.ArrayList;
import java.util.List;

/*
 * Model storing information about a place retrieved from the backend server.
 *
 * You will need to understand some of the code in this file and make changes starting with MP1.
 */
@SuppressWarnings("unused")
public final class Place {
  /*
   * The Jackson JSON serialization library that we are using requires an empty constructor.
   * So don't remove this!
   */
  public Place() {
    latitude = 1000;
    longitude = 1000;
// comment test
  }

  public Place(
      final String setId,
      final String setName,
      final double setLatitude,
      final double setLongitude,
      final String setDescription) {
    id = setId;
    name = setName;


    latitude = setLatitude;

    longitude  = setLongitude;


    description = setDescription;
  }


  // ID of the place
  private String id;

  public static List<Place> search(final List<Place> places, final String search) {
    if (places == null || search == null) {
      throw new IllegalArgumentException();
    }
    String myString = search.strip();
    if (places.isEmpty() || myString.isEmpty()) {
      return places;
    }
    System.out.println("changing string:" + myString);
    myString = myString.trim();
    List<Place> answer = new ArrayList<>();
    myString = myString.toUpperCase();
    // answer.add()

    for (int i = 0; i < places.size(); i++) {
      String currentString = places.get(i).getDescription();
      System.out.println(currentString);
      currentString = currentString.toUpperCase();
      currentString = currentString.replace('.', ' ' );
      currentString = currentString.replace('!', ' ');
      currentString = currentString.replace('?', ' ');
      currentString = currentString.replace(',', ' ');
      currentString = currentString.replace(';', ' ');
      currentString = currentString.replace(':', ' ');
      currentString = currentString.replace('/', ' ');
      currentString = currentString.replaceAll("[^A-Za-z0-9\\s]", "");

      System.out.println(currentString);

      String[] wordsInDescription = currentString.split(" ");

      for (String s : wordsInDescription) {
        if (s.equals(myString)) {
          answer.add(places.get(i));
          break;
        }
      }
      // make new array with each word
      // enhanced for loop (place in places)
      // make a new string array
      // if mystring.equals enhanced for loop then answer.add
      // break

    }
    return answer;
  }

  public String getId() {
    return id;
  }

  // Name of the person who submitted this favorite place
  private String name;

  public String getName() {
    return name;
  }

  // Latitude and longitude of the place
  private double latitude;

  public double getLatitude() {
    return latitude;
  }

  private double longitude;

  public double getLongitude() {
    return longitude;
  }

  // Description of the place
  private String description;



  public String getDescription() {
    return description;
  }
}
