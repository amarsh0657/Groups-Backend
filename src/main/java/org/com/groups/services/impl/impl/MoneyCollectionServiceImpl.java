package org.com.groups.services.impl.impl;

import org.com.groups.constants.MoneyCollectionConstant;
import org.com.groups.dto.Dashboard;
import org.com.groups.dto.MoneyCollectionDto;
import org.com.groups.dto.ResponseDto;
import org.com.groups.entity.MoneyCollection;
import org.com.groups.mapper.MoneyCollectionMapper;
import org.com.groups.repo.MoneyCollectionRepo;
import org.com.groups.services.impl.IMoneyCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MoneyCollectionServiceImpl implements IMoneyCollectionService {

    @Autowired
    private MoneyCollectionRepo moneyCollectionRepo;

    @Override
    public ResponseEntity<ResponseDto> collectMoney(MoneyCollectionDto moneyCollectionDto) {

        ResponseEntity<ResponseDto>  response = null;
        boolean checkForMonth = moneyCollectionRepo.existsByMemberSIDAndAndDepositMonthAndYear(
                moneyCollectionDto.getMemberSID(),
                moneyCollectionDto.getDepositMonth(),
                moneyCollectionDto.getYear()

        );

        if (checkForMonth){

            return response =  ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(
                    new ResponseDto(MoneyCollectionConstant.STATUS_409,
                            moneyCollectionDto.getDepositMonth() +MoneyCollectionConstant.MESSAGE_409)
                         );
        }else {
            MoneyCollection moneyCollection = MoneyCollectionMapper.mapToMoneyCollection(moneyCollectionDto, new MoneyCollection());
            MoneyCollection moneyCollectionSave = moneyCollectionRepo.save(moneyCollection);

          return   response =  ResponseEntity
                  .status(HttpStatus.CREATED)
                  .body(new ResponseDto
                          (MoneyCollectionConstant.STATUS_201, MoneyCollectionConstant.MESSAGE_201));
        }



    }


    public Page<MoneyCollection> getAllCollection(Pageable pageable) {

       return moneyCollectionRepo.findAll(pageable);
    }

    public Page<MoneyCollection> getCollectionByMemberSID(Pageable pageable ,String memberSid) {

        return moneyCollectionRepo.findAllByMemberSID(pageable, memberSid);
    }

    public Dashboard getDashboardData(String memberSid){
        Dashboard dashboard = new Dashboard() ;

          int totalCollectionAccount = moneyCollectionRepo.calculateTotalDepositAmount() ;

          int totalMaintenanceAccount = (totalCollectionAccount / 220 )  *20;

          int totalBankBalance = totalCollectionAccount -totalMaintenanceAccount ;



          int totalMyDepositAccount = moneyCollectionRepo.calculateMemberBySIDAccount(memberSid);
                 int noMonth = totalMyDepositAccount/220;
          int totalMyBankAccount = totalMyDepositAccount - (noMonth*20);

            dashboard.setTotalBankBalance(totalBankBalance);
            dashboard.setTotalCollectionAccount(totalCollectionAccount);
            dashboard.setTotalMaintenanceAccount(totalMaintenanceAccount);
            dashboard.setTotalMyDepositAccount(totalMyDepositAccount);
            dashboard.setTotalMyBankAccount(totalMyBankAccount);


        return dashboard;
    }

}
