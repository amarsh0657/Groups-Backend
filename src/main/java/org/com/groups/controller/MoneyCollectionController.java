package org.com.groups.controller;

import org.com.groups.constants.MoneyCollectionConstant;
import org.com.groups.dto.Dashboard;
import org.com.groups.dto.MoneyCollectionDto;
import org.com.groups.dto.ResponseDto;
import org.com.groups.entity.MoneyCollection;
import org.com.groups.services.impl.IMoneyCollectionService;
import org.com.groups.services.impl.impl.MoneyCollectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;



@RestController
@RequestMapping(path = "/api/collection", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class MoneyCollectionController {

    @Autowired
    IMoneyCollectionService iMoneyCollectionService;

    @Autowired
    MoneyCollectionServiceImpl moneyCollectionService;

    @GetMapping("/get")
    public ResponseEntity<Page<MoneyCollection>> getMoneyCollection(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size
    ){
        Pageable pageable = (Pageable) PageRequest.of( page, size,direction , sortBy);

        Page<MoneyCollection> moneyCollectionPage = moneyCollectionService.getAllCollection(pageable) ;

        return  new ResponseEntity<>(moneyCollectionPage,HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<Page<MoneyCollection>> getCollectionBySid(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String memberSid
    ){
        Pageable pageable = (Pageable) PageRequest.of( page, size,direction , sortBy);

        Page<MoneyCollection> moneyCollectionPageBySID = moneyCollectionService.getCollectionByMemberSID(pageable,memberSid) ;

        return  new ResponseEntity<>(moneyCollectionPageBySID,HttpStatus.OK);
    }



    @GetMapping("/dashboard")
    public ResponseEntity<Dashboard> getDashboard(
            @RequestParam String memberSid
    ){


        Dashboard dashboard = moneyCollectionService.getDashboardData(memberSid);

        return  new ResponseEntity<>(dashboard,HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createMoneyCollection(@Valid @RequestBody MoneyCollectionDto moneyCollectionDto){
        ResponseEntity<ResponseDto>  response =  iMoneyCollectionService.collectMoney(moneyCollectionDto);
        return response;
    }



}
