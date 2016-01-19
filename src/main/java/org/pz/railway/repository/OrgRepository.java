package org.pz.railway.repository;

import javax.persistence.QueryHint;

import org.pz.railway.entity.Org;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrgRepository extends PagingAndSortingRepository<Org, Long> {

	@QueryHints(value = { @QueryHint(name = "name", value = "value")}, forCounting = false)
	Page<Org> findByNameLike(String name, Pageable pageable);
}
