package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int RESIDENCY_PERIOD = 10;
    private static String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (getResidencyPeriod(candidate) > 9);
    }
    
    private int getResidencyPeriod(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        if (years[1].isEmpty() || years[1] == null) {
            years[1] = "2021";
        }
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
