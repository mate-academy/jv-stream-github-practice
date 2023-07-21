package practice;

import java.util.function.Predicate;
import model.Candidate;

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
                && getPeriod(candidate.getPeriodsInUkr()) >= REQUIRED_PERIOD;
    }

    private Integer getPeriod(String dates) {
        String[] separatedDates = dates.split(SEPARATOR_SYMBOL);
        return Integer.parseInt(separatedDates[TO_DATE_INDEX])
                - Integer.parseInt(separatedDates[FROM_DATE_INDEX]);
    }
}
