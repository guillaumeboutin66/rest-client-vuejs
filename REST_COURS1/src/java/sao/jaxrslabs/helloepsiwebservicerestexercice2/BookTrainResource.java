package sao.jaxrslabs.helloepsiwebservicerestexercice2;
 
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
 
/**
 *
 * @author M34LMAR }
 */
@Path("/booktrains") //   Chemin   suivant   /trains/booktrains   pour   invoquer   cette   méthode
@Produces("application/json")
public class BookTrainResource {
    public BookTrainResource(){
    }           
     @GET   //   Méthode   HTTP   utilisée   pour   déclencher   cette   méthode          
    public Response getBookTrains() {
        System.out.println("getBookTrains");
        return Response
                .ok( new GenericEntity<List<BookTrain>>(BookTrainBD.getBookTrains()){},MediaType.APPLICATION_JSON)
                .status(Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
        public BookTrainResource getBookTrainResource() {
        return new BookTrainResource();
    }
    @POST   //   Méthode   HTTP   utilisée   pour   déclencher   cette   méthode
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/createBookTrain")
    public Response createBookTrain(BookTrain nouveauBookTrain) {
        System.out.println("createBookTrain");
        Train currentTrain = null;
        for (Train current : BookTrainBD.getTrains()) {
            if (current.getNumTrain().equals(nouveauBookTrain.getBookNumber())) {
                currentTrain = current;
            }
        }
        BookTrain newBookTrain = new BookTrain();
        newBookTrain.setNumberPlaces(nouveauBookTrain.getNumberPlaces());
        newBookTrain.setCurrentTrain(currentTrain);
        newBookTrain.setBookNumber(Long.toString(System.currentTimeMillis()));
        BookTrainBD.getBookTrains().add(newBookTrain);
        System.out.println(newBookTrain.getBookNumber());
        return Response
                .ok(newBookTrain,MediaType.APPLICATION_JSON)
                .status(Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
  
    @GET   //   Méthode   HTTP   utilisée   pour   déclencher   cette   méthode
    @Path("{id}")   //   Chemin   de   façon   à   intégrer   un   template   parameter   (id)
    public Response getBookTrain(@PathParam("id") String bookNumber) {
        List<BookTrain> bookTrains = BookTrainBD.getBookTrains();
        for (BookTrain current : bookTrains) {
            if (current.getBookNumber().equals(bookNumber)) {
                return Response
                        .ok(current,MediaType.APPLICATION_JSON)
                        .status(Status.OK)
                        .build();
            }
        }
        return Response
                .status(Status.NO_CONTENT).build();
    }
 
    @DELETE   //   Méthode   HTTP   utilisée   pour   déclencher   cette   méthode
    @Path("{id}")   //   Chemin   de   façon   à   intégrer   un   template   parameter   (id)
    public Response removeBookTrain(@PathParam("id") String bookNumber) {
        BookTrain currentBookTrain = null;
        for (BookTrain current : BookTrainBD.getBookTrains()) {
            if (current.getBookNumber().equals(bookNumber)) {
                currentBookTrain = current;
            }
        }
        return Response.status(Status.ACCEPTED).build();
    }
 
}