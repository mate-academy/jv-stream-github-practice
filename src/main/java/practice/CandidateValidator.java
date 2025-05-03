package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS = 10;
    private static final String NATIONALITY_PROVE = "Ukrainian";
    private static final String SPLITTER = ",";
    private static final String HYPHEN = "-";
    private static final int END_YEAR = 1;
    private static final int START_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY_PROVE.equalsIgnoreCase(candidate.getNationality())
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        return Arrays.stream(periodsInUkr.split(SPLITTER))
                .map(period -> period.split(HYPHEN))
                .mapToInt(years -> Integer.parseInt(years[END_YEAR])
                        - Integer.parseInt(years[START_YEAR]))
                .sum() >= REQUIRED_YEARS;
    }
}
