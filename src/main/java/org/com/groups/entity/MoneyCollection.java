package org.com.groups.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Index;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class MoneyCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int year;
    private String depositMonth;
    private String memberName;
    private String email;

    @Index(name = "membersid")
    private String memberSID;

    private String depositBy;
    private int depositAccount;
    private LocalDate depositDate;
    private String depositMode;


}
