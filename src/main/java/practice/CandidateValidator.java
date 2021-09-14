package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UA_NATIONALITY = "Ukrainian";
    public static final int FIRST_YEAR = 0;
    public static final int SECOND_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            throw new RuntimeException("No candidate present!");
        }
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && UA_NATIONALITY.equals(candidate.getNationality())
                && wasTenYearsInUkraine(candidate);
    }

    private boolean wasTenYearsInUkraine(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[SECOND_YEAR])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FIRST_YEAR]) >= 10;
    }
}
