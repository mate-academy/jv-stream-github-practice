package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String period = candidate.getPeriodsInUkr();
        String[] arrYears = period.split("-");
        return (candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
               && candidate.getNationality().equals(NATIONALITY)
               && (Integer.parseInt(arrYears[1]) - Integer.parseInt(arrYears[0]))
               >= LIVE_IN_COUNTRY);
    }
}
