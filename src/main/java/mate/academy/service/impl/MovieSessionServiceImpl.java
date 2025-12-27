package mate.academy.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mate.academy.dao.MovieSessionDao;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.MovieSession;
import mate.academy.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }

    @Override
    public MovieSession get(Long id) {
        return movieSessionDao.get(id).orElse(null);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        List<MovieSession> res = new ArrayList<>();
        for (MovieSession session : movieSessionDao.getAll()) {
            if (session.getMovie().getId().equals(movieId)
                    && session.getShowTime().toLocalDate().equals(date)) {
                res.add(session);
            }
        }
        return res;
    }
}
