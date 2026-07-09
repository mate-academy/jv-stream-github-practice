package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_YEARS_IN_UKRAINE = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";

    private int getNumberByParsedYearsDates(Candidate candidate) {
        String[] array = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(array[1]) - Integer.parseInt(array[0]);
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && getNumberByParsedYearsDates(candidate) >= MINIMUM_YEARS_IN_UKRAINE;
    }
}
