package pl.setblack.pongi.scores;

import pl.setblack.pongi.scores.repo.ScoreRepositoryES;
import pl.setblack.pongi.scores.repo.ScoresRepository;
import pl.setblack.pongi.scores.repo.ScoresRepositoryProcessor;
import pl.setblack.pongi.scores.repo.ScoresRepositorySQL;

/**
 * Created by jarek on 2/13/17.
 */
public class ScoresModule {

    private final ScoresRepositoryProcessor scoresRepository;

    public ScoresModule(ScoresRepository scoresRepository) {
        this.scoresRepository = new ScoresRepositoryProcessor(scoresRepository);
    }

    public ScoresModule() {
        this ( new ScoresRepositorySQL());
    }

    public ScoresService createService() {
        return new ScoresService(scoresRepository);
    }

    public ScoresRepositoryProcessor getScoresRepository() {
        return this.scoresRepository;
    }
}
