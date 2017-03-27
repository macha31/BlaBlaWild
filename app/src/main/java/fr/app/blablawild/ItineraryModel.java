package fr.app.blablawild;

import java.util.Date;

/**
 * Created by M.C on 17/03/2017.
 */

public class ItineraryModel {
    private int id;
    private String lastName;
    private String firstName;
    private String date;
    private int price;
    private String departure;
    private String destination;

    private ItineraryModel(){

    }

    public ItineraryModel(int id, String lastName, String firstName, String date, int price, String departure, String destination){
        this.id = 0;
        this.lastName = "Devigne";
        this.firstName = "Arlette";
        this.date = date;
        this.price = price;
        this.departure = departure;
        this.destination = destination;
    }

    public int getId(){
        return this.id;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getDate(){
        return this.date;
    }

    public int getPrice(){
        return this.price;
    }

    public String getDeparture(){
        return this.departure;
    }

    public String getDestination(){
        return this.destination;
    }
}
