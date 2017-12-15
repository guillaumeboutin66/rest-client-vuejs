package sao.jaxrslabs.helloepsiwebservicerestexercice2;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
//@XmlRootElement(name = "booktrain")
public class BookTrain {
 
     private String bookNumber;
     private int numberPlaces;
    private Train currentTrain;
    
    
    public BookTrain(){
    }

    BookTrain(String booK123, Train train, int i) {
        this.bookNumber = booK123;
        this.currentTrain = train;
        this.numberPlaces = i;
        
    }
    public String getBookNumber() {
        return bookNumber;
    }
 
    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }
 
    public Train getCurrentTrain() {
        return currentTrain;
    }
 
    /**
     * @param currentTrain the currentTrain to set
     */
    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }
 
    /**
     * @return the numberPlaces
     */
    public int getNumberPlaces() {
        return numberPlaces;
    }
 
    /**
     * @param numberPlaces the numberPlaces to set
     */
    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }
 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */