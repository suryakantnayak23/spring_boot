package com.simplebank.Accounts.Dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String name;
    private String email;
    private String mobile_number;
    private AccountsDto accountsDto;
}
