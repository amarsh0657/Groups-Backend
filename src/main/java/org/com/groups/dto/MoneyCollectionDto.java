package org.com.groups.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MoneyCollectionDto {

    private int year;
    private String depositMonth;
    private String memberName;
    private String email;
    private String memberSID;
    private String depositBy;
    private int depositAccount;
    private LocalDate depositDate;
    private String depositMode;
}
