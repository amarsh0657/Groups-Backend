package org.com.groups.mapper;

import org.com.groups.dto.MoneyCollectionDto;
import org.com.groups.entity.MoneyCollection;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MoneyCollectionMapper {


    public static MoneyCollection mapToMoneyCollection(MoneyCollectionDto moneyCollectionDto, MoneyCollection moneyCollection){

              moneyCollection.setMemberName(moneyCollectionDto.getMemberName());
              moneyCollection.setEmail(moneyCollectionDto.getEmail());
              moneyCollection.setMemberSID(moneyCollectionDto.getMemberSID());
              moneyCollection.setYear(moneyCollectionDto.getYear());
              moneyCollection.setDepositMonth(moneyCollectionDto.getDepositMonth());
              moneyCollection.setDepositAccount(moneyCollectionDto.getDepositAccount());
              moneyCollection.setDepositBy(moneyCollectionDto.getDepositBy());

              moneyCollection.setDepositDate(LocalDate.now());
              moneyCollection.setDepositMode(moneyCollectionDto.getDepositMode());
          return moneyCollection;
    }




}
