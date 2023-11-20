package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY
            = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return validateAge(candidate.getAge())
                && candidate.isAllowedToVote()
                && validateNationality(candidate.getNationality())
                && validatePeriondsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean validateAge(int age) {
        return age >= MIN_AGE;
    }

    private boolean validateNationality(String nationality) {
        return nationality.equals(REQUIRED_NATIONALITY);
    }

    private boolean validatePeriondsInUkr(String periodsInUkr) {
        Integer[] value = Arrays.stream(periodsInUkr.split("-"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        return Math.abs(value[YEAR_FROM_INDEX]
                - value[YEAR_TO_INDEX]) >= MIN_PERIOD;
    }
}
