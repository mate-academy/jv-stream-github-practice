package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_RESIDENCY_YEARS = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsRange = candidate.getPeriodsInUkr().split("-");
        int stayDuration = Integer.parseInt(yearsRange[END_YEAR_INDEX]) - Integer
                .parseInt(yearsRange[START_YEAR_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && stayDuration >= MIN_RESIDENCY_YEARS;
    }
}
