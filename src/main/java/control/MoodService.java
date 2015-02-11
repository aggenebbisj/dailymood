
package control;

import entity.Mood;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MoodService {

    @PersistenceContext
    private EntityManager em;

    public void save(Mood mood) {
        em.persist(mood);
    }

    public List<Mood> findAll() {
        return em.createQuery("select m from Mood m", Mood.class).getResultList();
    }

    public List<Mood> findForToday() {
        TypedQuery<Mood> query = em.createQuery("select m from Mood m where m.date between :startDate and :endDate", Mood.class);
        query.setParameter("startDate", toUtilDate(LocalDate.now().atStartOfDay()));
        query.setParameter("endDate", toUtilDate(LocalDate.now().atTime(23, 59)));
        return query.getResultList();
    }
    
    private Date toUtilDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
}
