package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int SUITABLE_AGE = 35;
    private static final int SUITABLE_PERIOD_IN_UKRAINE = 10;
    private static final String SUITABLE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int startedToLiveInCountry = Integer.parseInt(candidate.getPeriodsInUkr()
                .replaceAll("-\\d+", ""));
        int finishedToLiveInCountry = Integer.parseInt(candidate.getPeriodsInUkr()
                .replaceAll("\\d+-", ""));
        return candidate.getNationality().equals(SUITABLE_NATIONALITY)
            && finishedToLiveInCountry - startedToLiveInCountry >= SUITABLE_PERIOD_IN_UKRAINE
            && candidate.getAge() >= SUITABLE_AGE && candidate.isAllowedToVote();
    }
}
