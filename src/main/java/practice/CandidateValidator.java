package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTABLE_AGE = 35;
    private static final int YEARS_OF_RESIDENCE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return candidate.getAge() >= ACCEPTABLE_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && endYear - startYear >= YEARS_OF_RESIDENCE;
    }
}
