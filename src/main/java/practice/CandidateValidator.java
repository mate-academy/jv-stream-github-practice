package practice;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Candidate;

public class CandidateValidator {

    public List<String> selectEligibleCandidates(List<Candidate> candidates) {
        if (candidates == null) {
            throw new RuntimeException("Input list is null");
        }
        return candidates.stream().filter(new CustomPredicate())
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private static class CustomPredicate implements Predicate<Candidate> {
        private static final int MIN_AGE = 35;
        private static final String NATIONALITY = "Ukrainian";
        private static final int MIN_TERM_OF_RESIDENCE = 10;

        @Override
        public boolean test(Candidate candidate) {
            return isValidFields(candidate) && candidate.getAge() >= MIN_AGE
                    && candidate.isAllowedToVote() && candidate.getNationality().equals(NATIONALITY)
                    && countYearsInUkraine(candidate.getPeriodsInUkr()) > MIN_TERM_OF_RESIDENCE;
        }

        private boolean isValidFields(Candidate candidate) {
            return candidate.getNationality() != null && candidate.getPeriodsInUkr() != null
                    && candidate.getName() != null;
        }

        private static int countYearsInUkraine(String period) {
            return Integer.parseInt(period.split("-")[1]) - Integer.parseInt(period.split("-")[0]);
        }
    }
}
