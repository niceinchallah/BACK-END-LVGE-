package com.test.test.service.impl;

import com.test.test.DTO.EXPENSEDTO;
import com.test.test.EXCEPTION.ResourceNOTfoundexception;
import com.test.test.entity.EXPENSE;
import com.test.test.mapper.EXPENSEmapper;
import com.test.test.repository.EXPENSErep;
import com.test.test.service.EXPENSEservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EXPENSEserviceimpl implements EXPENSEservice {
    private EXPENSErep expensErep;
    @Override
    public EXPENSEDTO createEXPENSE(EXPENSEDTO expensedto) {
        EXPENSE expense = EXPENSEmapper.mapToEXPENSE(expensedto);
        EXPENSE savedEXPENSE = expensErep.save(expense);
        return EXPENSEmapper.mapToEXPENSEDTO(savedEXPENSE);
    }

    @Override
    public EXPENSEDTO getEXPENSEbyid(Long EXPENSEid) {
        EXPENSE expense = expensErep.findById(EXPENSEid)
                .orElseThrow(()->
                        new ResourceNOTfoundexception("not exist with guven id "+EXPENSEid));
        return EXPENSEmapper.mapToEXPENSEDTO(expense);
    }

    @Override
    public List<EXPENSEDTO> getAllEXPENSE() {
        return null;
    }

    @Override
    public EXPENSEDTO updatedEXPENSE(Long EXPENSEid, EXPENSEDTO updatedEXPENSE) {
        EXPENSE expense = expensErep.findById(EXPENSEid).orElseThrow(()
        -> new ResourceNOTfoundexception("not exist with given id:"+ EXPENSEid));
        expense.setName(updatedEXPENSE.getName());
        expense.setId(updatedEXPENSE.getId());
        expense.setVALUE(updatedEXPENSE.getVALUE());
        expense.setDate(updatedEXPENSE.getDate());
        EXPENSE updatedEXPENSEObj = expensErep.save(expense);
        return EXPENSEmapper.mapToEXPENSEDTO(updatedEXPENSEObj);
    }

    @Override
    public void deleteEXPENSE(Long EXPENSEid) {
        EXPENSE expense = expensErep.findById(EXPENSEid).orElseThrow(()
                -> new ResourceNOTfoundexception("not exist with given id:"+ EXPENSEid));
        expensErep.deleteById(EXPENSEid);
    }
}
