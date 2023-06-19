package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_MIN = 35;
    private static final int START_INDEX = 0;
    private static final int ONE = 1;
    private static final int TERM_LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY_CANDIDATE = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean period = Stream.of(candidate)
                .anyMatch(person -> {
                    String periodsInUkr = person.getPeriodsInUkr();
                    return checkPeriodsInUkraine(periodsInUkr);
                });
        return candidate.getAge() >= AGE_MIN
                && candidate.getNationality().equals(NATIONALITY_CANDIDATE)
                && candidate.isAllowedToVote()
                && period;
    }

    private boolean checkPeriodsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        int startYear = Integer.parseInt(years[START_INDEX]);
        int endYear = Integer.parseInt(years[ONE]);
        return ((endYear - startYear) >= TERM_LIVE_IN_UKRAINE);
    }
}
