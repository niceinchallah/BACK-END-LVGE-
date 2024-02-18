package com.test.test.service.impl;

import com.test.test.DTO.DETECTEDDTO;
import com.test.test.EXCEPTION.ResourceNOTfoundexception;
import com.test.test.entity.DETECTED;
import com.test.test.mapper.DETECTEDmapper;
import com.test.test.repository.DETECTEDrep;
import com.test.test.service.DETECTEDservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class DETECTEDserviceimpl  implements DETECTEDservice {
    private DETECTEDrep detecteDrep;
    @Override
    public DETECTEDDTO createDETECTED(DETECTEDDTO detecteddto) {
        DETECTED detected= DETECTEDmapper.mapToDETECTED(detecteddto);
       DETECTED savedDETECTED =  detecteDrep.save(detected);
        return DETECTEDmapper.mapToDETECTEDDTO(savedDETECTED);
    }

    @Override
    public DETECTEDDTO getDETECTEDbyid(Long DETECTEDID) {
        DETECTED detected = detecteDrep.findById(DETECTEDID)
                .orElseThrow(()->
                        new ResourceNOTfoundexception("not exist with given id "+ DETECTEDID));

        return DETECTEDmapper.mapToDETECTEDDTO(detected);
    }

    @Override
    public List<DETECTEDDTO> getAllDETECTED() {
        List<DETECTED> detectedList = detecteDrep.findAll();
        return detectedList.stream()
                .map(DETECTEDmapper::mapToDETECTEDDTO)
                .collect(Collectors.toList());
    }


    @Override
    public DETECTEDDTO updateDETECTED(Long DETECTEDid, DETECTEDDTO updatedDETECTED) {
        DETECTED detected = detecteDrep.findById(DETECTEDid).orElseThrow(()
        ->new ResourceNOTfoundexception("not exist with given id "+ DETECTEDid)

                );
        detected.setId(updatedDETECTED.getId());
        detected.setDate(updatedDETECTED.getDate());
        detected.setPhoto(updatedDETECTED.getPhoto());
        DETECTED updatedDETECTEDObj=detecteDrep.save(detected);

        return DETECTEDmapper.mapToDETECTEDDTO(updatedDETECTEDObj);
    }

    @Override
    public void deleteDETECTED(Long DETECTEDid) {
        DETECTED detected = detecteDrep.findById(DETECTEDid).orElseThrow(()
                ->new ResourceNOTfoundexception("not exist with given id "+ DETECTEDid)

        );
        detecteDrep.deleteById(DETECTEDid);
    }

}
