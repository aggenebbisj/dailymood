
package boundary;

import control.MoodService;
import entity.Mood;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("mood")
public class MoodsResource {
    
    @Inject
    private MoodService moodService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mood> get() {
        return moodService.findAll();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("today")
    public List<Mood> getToday() {
        return moodService.findForToday();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("today/stats")
    public MoodStats getStats() {
        double average = moodService
                .findForToday()
                .stream()
                .mapToInt(Mood::getValue)
                .average()
                .orElse(2);
        return new MoodStats(average);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public Response post(@FormParam("mood") int moodValue, @Context HttpServletRequest request) {
        moodService.save(new Mood(moodValue, new Date(), request.getRemoteAddr()));
        
        return Response
                .status(Response.Status.MOVED_PERMANENTLY)
                .header("Location", "mood/today/stats")
                .build();
    } 
}
