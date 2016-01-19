package org.pz.railway.repository;

import java.util.List;

import org.pz.railway.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
	List<Account> findByAccount(String account);
}
