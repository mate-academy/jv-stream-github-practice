package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && livedInUkraineLongEnough(candidate.getPeriodsInUkr());
    }

    public boolean livedInUkraineLongEnough(String periods) {
        if (periods == null || periods.isEmpty()) {
            return false;
        }

        return Arrays.stream(periods.split(";"))
                .map(range -> range.split("-"))
                .filter(years -> years.length == 2)
                .mapToInt(years -> Integer.parseInt(years[1].trim())
                        - Integer.parseInt(years[0].trim()))
                .sum() >= MIN_YEARS_IN_UKR;
    }
}
