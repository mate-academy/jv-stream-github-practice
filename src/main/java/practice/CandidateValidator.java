package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_AMOUNT_YEAR_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int INDEX_START_LIVING_IN_UKRAIN = 0;
    private static final int INDEX_FINISH_LIVING_IN_UKRAIN = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodString = candidate.getPeriodsInUkr().split(SEPARATOR);
        int startLivinInUkraine = Integer
                .parseInt(periodString[INDEX_START_LIVING_IN_UKRAIN]);
        int finishLiviningInUkrkaine = Integer
                .parseInt(periodString[INDEX_FINISH_LIVING_IN_UKRAIN]);
        int period = finishLiviningInUkrkaine - startLivinInUkraine;
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= MIN_AMOUNT_YEAR_IN_UKRAINE;
    }

}
