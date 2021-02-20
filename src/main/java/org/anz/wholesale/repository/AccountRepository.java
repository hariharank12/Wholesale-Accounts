package org.anz.wholesale.repository;

import org.anz.wholesale.entity.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hariharank12 on 25/11/20.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Find all accounts by user id list.
     *
     * @param userId   the user id
     * @param pageable the pageable
     * @return the list
     */
    List<Account> findAllAccountsByUserId(final String userId, final Pageable
            pageable);

}
