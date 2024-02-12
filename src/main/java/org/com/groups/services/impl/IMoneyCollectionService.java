package org.com.groups.services.impl;

import org.com.groups.dto.MoneyCollectionDto;
import org.com.groups.dto.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface IMoneyCollectionService {


     ResponseEntity<ResponseDto> collectMoney(MoneyCollectionDto moneyCollectionDto);
  //   Page<MoneyCollectionDto> getAllCollection(Pageable pageable);

}
