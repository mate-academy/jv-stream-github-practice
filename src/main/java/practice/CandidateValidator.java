package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodData = (candidate.getPeriodsInUkr().split("-"));
        int yearFrom = Integer.parseInt(periodData[0]);
        int yearTo = Integer.parseInt(periodData[1]);
        int difference = yearTo - yearFrom;

        return candidate.getAge() >= MIN_AGE
            && candidate.isAllowedToVote()
            && candidate.getNationality().equals(REQUIRED_NATIONALITY)
            && difference >= MIN_YEARS;
    }
}
