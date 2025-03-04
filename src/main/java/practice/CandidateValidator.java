package practice;

import model.Candidate;

import java.util.function.Predicate;


public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return Candidate.getAge() > 35 &&
                Candidate.isAllowedToVote() &&
                "Ukrainian".equals(Candidate.getNationality()) &&
                getPeriodsInUkr(Candidate.getPeriodsInUkr());
    }
    private boolean getPeriodsInUkr(String periods) {
        String[] years = periods.split("-");
        if (years.length == 2) {
            try {
                int startYear = Integer.parseInt(years[0]);
                int endYear = Integer.parseInt(years[1]);
                return (endYear - startYear) >= 10;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
        }
