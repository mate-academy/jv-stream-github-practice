package practice;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int MIN_RESIDENCE_TIME = 10;
    private static final String RESIDENCE_TIME_DELIMITER = "-";
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && Objects.equals(candidate.getNationality(), CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && getResidenceTime(candidate.getPeriodsInUkr()) >= MIN_RESIDENCE_TIME;
    }

    private int getResidenceTime(String period) {
        int[] years = Arrays.stream(period.split(RESIDENCE_TIME_DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
        return years[END_YEAR] - years[START_YEAR];
    }
}
