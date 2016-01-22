package org.pz.railway.repository;

import java.util.List;

import org.pz.railway.entity.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Long> {
	public List<Token> findByAccountId(Long accountId);
}