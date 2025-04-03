package com.simplebank.Accounts.service;

import com.simplebank.Accounts.Dto.CustomerDto;

public interface AccountService {

    /**
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber- input mobile number
     * @return Account details based on a given mobile number
     **/

    CustomerDto fetchAccount(String mobileNumber);

    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */

    boolean updateAccount(CustomerDto customerDto);

}
