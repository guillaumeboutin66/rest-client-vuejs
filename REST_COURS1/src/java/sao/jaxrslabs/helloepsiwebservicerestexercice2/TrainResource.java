package sao.jaxrslabs.helloepsiwebservicerestexercice2;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/trains")
@Produces("application/json")
public class TrainResource { 
public TrainResource(){
}
@GET
public Response getTrains(){
    System.out.println("getTrains");
       return Response
                .ok( new GenericEntity<List<Train>>(BookTrainBD.getTrains()){},MediaType.APPLICATION_JSON)
                .status(Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .build();
}
@GET
@Path("numTrain-{id}")
public Response getTrain(
@PathParam("id") String numTrain){
    System.out.println("getTrain");
    for(Train current : BookTrainBD.getTrains()){
        if(numTrain.equals(current.getNumTrain())){
            return Response.ok(current,MediaType.APPLICATION_JSON).status(Status.OK).build();
        }
    }
    return Response
            .ok( new GenericEntity<List<Train>>(BookTrainBD.getTrains().subList(0,2)){},MediaType.APPLICATION_JSON)
            .status(Status.OK)
            .build();
}
@GET
@Path("/search")
public Response searchTrainsByCriteria(
@QueryParam("departure") String departure,
        @QueryParam("arrival") String arrival,
        @QueryParam("arrivalhour") int arrivalHour){
    System.out.println("searchTrainsByCriteria");
    List<Train> dispos = BookTrainBD.getTrains();
    List<Train> searchs = new ArrayList<>();
    for(Train train : dispos){
        if(train.getVilleDepart().equals(departure)
                || train.getVilleArrivee().equals(arrival)
                || train.getHeureDepart()==arrivalHour){
            searchs.add(train);
        }
    }
    return Response
            .ok(new GenericEntity<List<Train>>(searchs){},MediaType.APPLICATION_JSON)
            .status(Status.OK)
            .build();
}
}