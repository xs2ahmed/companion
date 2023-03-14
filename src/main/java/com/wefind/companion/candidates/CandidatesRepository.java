package com.wefind.companion.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatesRepository extends JpaRepository<Candidate, Long> {

    Candidate getCandidateByPhoneEquals(String phone);

}