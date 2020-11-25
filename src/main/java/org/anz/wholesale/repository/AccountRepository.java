package org.anz.wholesale.repository;

import org.anz.wholesale.entity.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hariharank12 on 25/11/20.
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>
{
    List<Account> findAllAccountsByUserId(String userId, Pageable pageable);

}
