package org.com.groups.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dashboard {

    private  double totalCollectionAccount ;

    private  double totalMaintenanceAccount ;

    private  double totalBankBalance;

    private  double totalMyDepositAccount;

    private  double totalMyBankAccount;

}
