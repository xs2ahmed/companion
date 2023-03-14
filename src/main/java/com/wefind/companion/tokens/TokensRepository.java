package com.wefind.companion.tokens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Generate methods using this documentation
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

@Repository
public interface TokensRepository extends JpaRepository<Token, Long> {

    List<Token> findByPhoneContaining(String phone);
    //@Query("DELETE FROM Token t WHERE t.phone =: ?1")
    //public void deleteByPhone(String phone);
    @Transactional
    void deleteByPhoneEquals(String phone);

    boolean existsByPhoneAndToken(String phone, String token);

    @Transactional
    List<Token>  findByPhoneEqualsAndTokenEquals(String phone, String token);

}