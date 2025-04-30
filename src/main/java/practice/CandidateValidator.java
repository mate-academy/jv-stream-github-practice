package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int LOWER_AGE_LIMIT = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int YEARS_NUMBER_LIVED_IN_UKRAINE = 10;
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= LOWER_AGE_LIMIT && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] strings = candidate.getPeriodsInUkr().split(SEPARATOR);
        int yearFrom = Integer.parseInt(strings[BEGIN_INDEX]);
        int yearTo = Integer.parseInt(strings[END_INDEX]);
        if (yearTo >= yearFrom) {
            return (yearTo - yearFrom) >= YEARS_NUMBER_LIVED_IN_UKRAINE;
        }
        throw new RuntimeException("Incorrect period, first year must be less than second");
    }
}
