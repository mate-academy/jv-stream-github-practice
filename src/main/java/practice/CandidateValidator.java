package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY_FOR_VOTE = "Ukrainian";
    public static final String SEPARATOR_FOR_PERIODS_DATA = ",";
    public static final String SEPARATOR_FOR_ONE_PERIOD = "-";
    public static final int MIN_COUNT_YEARS_IN_UKRAINE = 10;
    public static final int MIN_AGE_FOR_VOTE = 35;
    public static final int START_PERIOD = 0;
    public static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR_FOR_PERIODS_DATA);
        int livedInUkraine = Arrays.stream(periods)
                .mapToInt(period -> {
                    String[] years = period.split(SEPARATOR_FOR_ONE_PERIOD);
                    return Integer.parseInt(years[END_PERIOD])
                            - Integer.parseInt(years[START_PERIOD]);
                })
                .sum();

        return candidate.getAge() >= MIN_AGE_FOR_VOTE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_FOR_VOTE)
                && livedInUkraine >= MIN_COUNT_YEARS_IN_UKRAINE;
    }
}
