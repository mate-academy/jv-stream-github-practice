package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static int MIN_TIME_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int timeInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && timeInUkraine >= MIN_TIME_IN_UKRAINE
                && candidate.isAllowedToVote();

    }

}
