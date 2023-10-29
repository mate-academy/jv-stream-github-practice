package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MINIMAL_ACCEPTABLE_CANDIDATE_AGE = 35;
    public static final int INDEX_OF_SINCE_YEAR_IN_COUNTRY = 0;
    public static final int INDEX_OF_TO_YEAR_IN_COUNTRY = 1;
    public static final String CANDIDATE_ACCEPTABLE_COUNTRY = "Ukrainian";
    public static final int MINIMAL_ACCEPTABLE_AGE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr().split("-");
        int ageFrom = Integer.parseInt(ages[INDEX_OF_SINCE_YEAR_IN_COUNTRY]);
        int ageTo = Integer.parseInt(ages[INDEX_OF_TO_YEAR_IN_COUNTRY]);
        return candidate.getAge() >= MINIMAL_ACCEPTABLE_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_ACCEPTABLE_COUNTRY)
                && ageTo - ageFrom >= MINIMAL_ACCEPTABLE_AGE_IN_COUNTRY;
    }
}
