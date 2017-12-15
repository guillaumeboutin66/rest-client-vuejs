/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sao.jaxrslabs.helloepsiwebservicerestexercice2;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mokayz
 */
public class BookTrainBD {
    private static List<Train> trains = new ArrayList<Train>();
    private static List<BookTrain> bookTrains = new ArrayList<>();
    
    static{
        trains.add(new Train("TR123","Poitiers","Paris",1250));
        trains.add(new Train("TR127","Poitiers","Paris",1420));
        trains.add(new Train("TR129","Poitiers","Paris",1710));
        trains.add(new Train("TR129","Tarbes","Paris",1710));
        trains.add(new Train("TR129","Paris","Marseille",1710));
        trains.add(new Train("TR129","Montpellier","Toulouse",1710));
        bookTrains.add(new BookTrain("BOOK123", new Train("TR123", "Poitiers", "Paris", 1250), 250));
        bookTrains.add(new BookTrain("BOOK127", new Train("TR127", "Poitiers", "Paris", 1420), 420));
        bookTrains.add(new BookTrain("BOOK129", new Train("TR129", "Poitiers", "Paris", 1710), 710));
    }
    
    public static List<Train> getTrains(){
        return trains;
    }
    public static List<BookTrain> getBookTrains(){
        return bookTrains;
    }
}
