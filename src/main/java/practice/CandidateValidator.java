package practice;

import model.Candidate;

import java.util.function.Function;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THAN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final Integer REQUIRED_PERIOD = 10;
    private static final String SEPARATOR_SYMBOL = "-";
    private static final int FROM_DATE_INDEX = 0;
    private static final int TO_DATE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= OLDER_THAN_AGE
                && candidate.isAllowedToVote()
                && (candidate.getNationality() != null
                && candidate.getNationality().equals(REQUIRED_NATIONALITY))
                && getPeriod.apply(candidate.getPeriodsInUkr()) >= REQUIRED_PERIOD;
    }

    private final Function<String, Integer> getPeriod = s -> {
        String[] separatedDates = s.split(SEPARATOR_SYMBOL);
        return Integer.parseInt(separatedDates[TO_DATE_INDEX])
                - Integer.parseInt(separatedDates[FROM_DATE_INDEX]);
    };
}
