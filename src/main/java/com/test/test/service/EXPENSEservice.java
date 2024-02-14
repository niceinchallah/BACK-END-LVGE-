package com.test.test.service;

import com.test.test.DTO.EXPENSEDTO;

import java.util.List;

public interface EXPENSEservice {
    EXPENSEDTO createEXPENSE(EXPENSEDTO expensedto);
    EXPENSEDTO getEXPENSEbyid(Long EXPENSEid);
    List<EXPENSEDTO> getAllEXPENSE();
    EXPENSEDTO updatedEXPENSE(Long Expenseid,EXPENSEDTO updatedEXPENSE);
    void deleteEXPENSE(Long EXPENSEid);
}
