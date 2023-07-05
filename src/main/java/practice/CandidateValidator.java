package practice;

import model.*;

import java.util.function.*;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int MIN_PERIOD = 10;
    public static final String NATIONALITY = "Ukrainian";
    public static final String SPLIT_CHAR = "-";
    @Override
    public boolean test(Candidate candidate) {
        final boolean ageValid = candidate.getAge() >= MIN_AGE;
        final boolean allowedToVote = candidate.isAllowedToVote();
        final boolean ukrainian = candidate.getNationality().equals(NATIONALITY);
        String[] period = candidate.getPeriodsInUkr().split(SPLIT_CHAR);
        int startYear = Integer.parseInt(period[0]);
        int endYear = Integer.parseInt(period[1]);
        boolean periodValid = (endYear - startYear + 1) >= MIN_PERIOD;
        return ageValid && allowedToVote && ukrainian && periodValid;
    }
}
