package practice;

import model.Candidate;
import java.util.Arrays;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && "Ukrainian".equals(candidate.getNationality())
                && Arrays.stream(candidate.getPeriodsInUkr()
                        .split(",")) // Розділяємо періоди
                .anyMatch(period -> {
                    String[] years = period.split("-");
                    int startYear = Integer.parseInt(years[0]);
                    int endYear = Integer.parseInt(years[1]);
                    return endYear - startYear >= 10; // Перевіряємо різницю між роками
                });
    }
}
