/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sao.jaxrslabs.helloepsiwebservicerestexercice2;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Mokayz
 */
@XmlRootElement(name="train")
public class Train {

private String numTrain;
private String villeDepart;
private String villeArrivee;
private int heureDepart; // format 1230 = 12h30

public Train(){
}
public Train(String numTrain,String villeDepart,String villeArrivee,int heureDepart){
    this.numTrain = numTrain;
    this.villeDepart = villeDepart;
    this.villeArrivee = villeArrivee;
    this.heureDepart = heureDepart;
}
    public String getNumTrain() {
        return numTrain;
    }

    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }
}