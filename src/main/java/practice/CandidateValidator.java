package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int LOWER_AGE_LIMIT = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int YEARS_NUMBER_LIVED_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= LOWER_AGE_LIMIT && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && (getNumbetOfYears(candidate.getPeriodsInUkr()) >= YEARS_NUMBER_LIVED_IN_UKRAINE);
    }

    private int getNumbetOfYears(String string) {
        String[] strings = string.split("-");
        return Integer.parseInt(strings[1]) - Integer.parseInt(strings[0]);
    }
}
