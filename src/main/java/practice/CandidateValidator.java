package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int INDEX_OF_DATE_FROM = 0;
    public static final int INDEX_OF_DATE_TO = 1;
    public static final int MINIMUM_AGE_OF_CANDIDATE = 35;
    public static final int MINIMUM_YEARS_LIVED_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] rangeLiveInUkraine = candidate.getPeriodsInUkr().split("-");
        int liveInUkraineFrom = Integer.parseInt(rangeLiveInUkraine[INDEX_OF_DATE_FROM]);
        int liveInUkraineTo = Integer.parseInt(rangeLiveInUkraine[INDEX_OF_DATE_TO]);
        return candidate.getAge() >= MINIMUM_AGE_OF_CANDIDATE && candidate.isAllowedToVote()
            && candidate.getNationality().equals("Ukrainian")
            && liveInUkraineTo - liveInUkraineFrom >= MINIMUM_YEARS_LIVED_IN_UKRAINE;
    }
}