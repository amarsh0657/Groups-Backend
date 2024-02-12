package org.com.groups.repo;

import org.com.groups.dto.MoneyCollectionDto;
import org.com.groups.entity.MoneyCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MoneyCollectionRepo extends JpaRepository<MoneyCollection,Long> {


    boolean existsByMemberSIDAndAndDepositMonthAndYear(String memberSid,String depositMonth, int year);
    Page<MoneyCollection> findAllByMemberSID(Pageable pageable , String memberSid);

    @Query("SELECT SUM(d.depositAccount) FROM MoneyCollection d")
    int calculateTotalDepositAmount();

    @Query("SELECT SUM(d.depositAccount) FROM MoneyCollection d  where   d.memberSID =  :memberSID")
    int calculateMemberBySIDAccount(@Param("memberSID") String memberSID);



}
