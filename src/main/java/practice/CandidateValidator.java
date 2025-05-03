package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UA_NATIONALITY = "Ukrainian";
    public static final int MIN_TERM_IN_UA = 10;
    public static final int MIN_AGE = 35;
    public static final int FIRST_YEAR = 0;
    public static final int SECOND_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            throw new RuntimeException("No candidate present!");
        }
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && UA_NATIONALITY.equals(candidate.getNationality())
                && wasTenYearsInUkraine(candidate);
    }

    private boolean wasTenYearsInUkraine(Candidate candidate) {
        String[] yearsInUa = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(yearsInUa[SECOND_YEAR])
                - Integer.parseInt(yearsInUa[FIRST_YEAR]) >= MIN_TERM_IN_UA;
    }
}
