package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int RESIDENCE_YEARS = 10;
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split(SPLITTER);
        int totalYearsInUkraine = Integer.parseInt(periodsInUkraine[1])
                - Integer.parseInt(periodsInUkraine[0]);
        return candidate.getAge() >= CANDIDATE_AGE
                && totalYearsInUkraine >= RESIDENCE_YEARS
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
