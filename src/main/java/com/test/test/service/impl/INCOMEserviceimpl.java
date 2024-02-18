package com.test.test.service.impl;


import com.test.test.DTO.INCOMEDTO;
import com.test.test.EXCEPTION.ResourceNOTfoundexception;
import com.test.test.entity.INCOME;
import com.test.test.mapper.INCOMEmapper;
import com.test.test.repository.INCOMErep;
import com.test.test.service.INCOMEservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
@AllArgsConstructor
public class INCOMEserviceimpl implements INCOMEservice {
    private INCOMErep incomErep;
    @Override
    public INCOMEDTO createINCOME(INCOMEDTO incomedto) {

       INCOME income=INCOMEmapper.mapToINCOME(incomedto);
        INCOME savedINCOME = incomErep.save(income);
        return INCOMEmapper.mapToINCOMEDTO(savedINCOME);
    }

    @Override
    public INCOMEDTO getINCOMEbyid(Long INCOMEid) {
        INCOME income = incomErep.findById(INCOMEid)
                .orElseThrow(()->
                        new ResourceNOTfoundexception("not exist with given id "+ INCOMEid));
        return INCOMEmapper.mapToINCOMEDTO(income);
    }

    @Override
    public List<INCOMEDTO> getAllINCOMES() {
        List<INCOME> incomes =incomErep.findAll();
        return incomes.stream()
                .map(INCOMEmapper::mapToINCOMEDTO)
                .collect(Collectors.toList());
    }

    @Override
    public INCOMEDTO updateINCOME(Long INCOMEid, INCOMEDTO updatedINCOME) {
        INCOME income = incomErep.findById(INCOMEid).orElseThrow(()
        ->new ResourceNOTfoundexception("not exist with given id "+INCOMEid)
                );
        income.setName(updatedINCOME.getName());
        income.setDate(updatedINCOME.getDate());
        income.setId(updatedINCOME.getId());
        income.setVALUE(updatedINCOME.getVALUE());
        INCOME updatedINCOMEobj = incomErep.save(income);
        return INCOMEmapper.mapToINCOMEDTO(updatedINCOMEobj)
                ;
    }

    @Override
    public void deleteINCOME(Long INCOMEid) {
        INCOME income = incomErep.findById(INCOMEid).orElseThrow(()
                ->new ResourceNOTfoundexception("not exist with given id "+INCOMEid)
        );
        incomErep.deleteById(INCOMEid);
    }
}
