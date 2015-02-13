package boundary;

import entity.Tags;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import control.MoodService;
import entity.Mood;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

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
        List<Mood> dailyMoods = moodService.findForToday();

        int sad = sumOfMoods(dailyMoods, 1);
        int neutral = sumOfMoods(dailyMoods, 2);
        int happy = sumOfMoods(dailyMoods, 3);

        double average = moodService
                .findForToday()
                .stream()
                .mapToInt(Mood::getValue)
                .average()
                .orElse(2);

        return new MoodStats(average, happy, neutral, sad);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("today/tags")
    public Tags getTags() {
        List<Mood> dailyMoods = moodService.findForToday();

        Set<String> happy = new HashSet<>();
        Set<String> neutral = new HashSet<>();
        Set<String> sad = new HashSet<>();

        Tags result = new Tags();
        dailyMoods.stream().forEach(result::add);

        return result;
    }

    private int sumOfMoods(List<Mood> moods, int mood) {
        return moods
                .stream()
                .mapToInt(Mood::getValue)
                .filter(value -> value == mood)
                .sum();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response post(@FormParam("mood") int moodValue, @DefaultValue("") @FormParam("tags") String tags, @Context HttpServletRequest request) {
        moodService.save(new Mood(moodValue, new Date(), request.getRemoteAddr(), getUniqueTags(tags)));
        return Response
                .status(Response.Status.MOVED_PERMANENTLY)
                .header("Location", "../stats.html")
                .build();
    }

    private HashSet<String> getUniqueTags(String tags) {
        Splitter splitter = Splitter.on(",").trimResults();
        Iterable<String> splitTags = splitter.split(tags);
        return Sets.newHashSet(splitTags);
    }
}
