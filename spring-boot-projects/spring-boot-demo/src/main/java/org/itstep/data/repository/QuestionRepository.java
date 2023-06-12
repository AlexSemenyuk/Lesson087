package org.itstep.data.repository;

import org.itstep.data.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {


    Optional<Question> findByTitleAndDescriptionIsNotNull(String title);
    Optional<Question> findByTitle(String title);

    @Query("select q, v from Question q left join fetch Vote v on v.question = q")
    List<Question> findAllEager();

}
