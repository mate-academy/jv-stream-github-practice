package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final String YEAR_DELIMITER = "-";
    private static final int MINIMUM_RESIDENCE = 10;

    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        boolean isUkrainian = UKRAINIAN_NATIONALITY.equals(candidate.getNationality());
        boolean hasVotingRights = candidate.isAllowedToVote();
        String[] periods = candidate.getPeriodsInUkr().split(YEAR_DELIMITER);
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        boolean hasLivedInUkraineFor10Years = (endYear - startYear) >= MINIMUM_RESIDENCE;

        return age >= MINIMUM_AGE && isUkrainian && hasVotingRights && hasLivedInUkraineFor10Years;
    }
}
