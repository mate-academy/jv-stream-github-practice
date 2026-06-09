package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int LIVING_TIME_IN_COUNTRY = 10;

    // string has following view: "2002-2015"
    private static Integer timeLivingInCountry(String fromTo) {
        String[] parts = fromTo.split("-");
        if (parts.length == 2) {
            return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]);
        }

        throw new IllegalArgumentException("Invalid from-to: " + fromTo);
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && timeLivingInCountry(candidate.getPeriodsInUkr())
                >= LIVING_TIME_IN_COUNTRY;
    }
}
