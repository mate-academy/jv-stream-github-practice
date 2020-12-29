package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REGEX = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_TIME_RESIDENT = 10;
    private static final int PARSE_INDEX_START_YEAR = 0;
    private static final int PARSE_INDEX_END_YEAR = 1;
    
    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        int periodInUkraine = Integer.parseInt(yearsInUkraine[PARSE_INDEX_END_YEAR])
                - Integer.parseInt(yearsInUkraine[PARSE_INDEX_START_YEAR]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraine >= MIN_TIME_RESIDENT;
    }
}
