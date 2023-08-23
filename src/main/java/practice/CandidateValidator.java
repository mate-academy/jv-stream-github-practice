package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";

    private int calculateAgeDifference(String periodsInUkraine) {
        String[] years = periodsInUkraine.split("-");
        if (years.length == 2) {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            return endYear - startYear;
        }
        return 0;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals(NATIONALITY)
                && calculateAgeDifference(candidate.getPeriodsInUkr()) > 10;
    }
}



