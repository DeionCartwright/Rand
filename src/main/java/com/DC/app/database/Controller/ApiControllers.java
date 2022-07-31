package com.DC.app.database.Controller;

import com.DC.app.database.Models.AssetDetails;
import com.DC.app.database.Models.VisitDetails;
import com.DC.app.database.Repo.AssetRepo;
import com.DC.app.database.Repo.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


@RestController
public class ApiControllers {

    @Autowired
    private AssetRepo assetRepo;
    @Autowired
    private VisitRepo visitRepo;

    @GetMapping(value = "/assets")
    public List<AssetDetails> getAsset() {
        return assetRepo.findAll();
    }

    @GetMapping(value="/visits")
    public List<VisitDetails> getVisit() {
        return visitRepo.findAll();
    }

    @PostMapping(value="/saveasset")
    public ResponseEntity<AssetDetails> saveAsset(@RequestBody AssetDetails asset) {
        assetRepo.save(asset);
        return ResponseEntity.ok(asset);
    }

    @PostMapping(value="/savevisit")
    public ResponseEntity saveVisit(@RequestBody VisitDetails visit) {
        visitRepo.save(visit);
        return ResponseEntity.ok(visit);
    }

    @PutMapping(value = "/updateasset/{assetID}")
    public ResponseEntity<AssetDetails> updateAsset(@PathVariable long assetID, @RequestBody AssetDetails asset) {
        AssetDetails updatedAsset = assetRepo.findById(assetID).get();
        updatedAsset.setUPRN(asset.getUPRN());
        updatedAsset.setAddressOne(asset.getAddressOne());
        updatedAsset.setAddressTwo(asset.getAddressTwo());
        updatedAsset.setPostcode(asset.getPostcode());
        assetRepo.save(updatedAsset);
        return ResponseEntity.ok(updatedAsset);
    }

    @PutMapping(value = "/updatevisit/{visitID}")
    public ResponseEntity<VisitDetails> updateVisit(@PathVariable long visitID, @RequestBody VisitDetails visit) {
        VisitDetails updatedVisit = visitRepo.findById(visitID).get();
        updatedVisit.setVisitType(visit.getVisitType());
        updatedVisit.setSurveyDate(visit.getSurveyDate());
        updatedVisit.setNextSurvey(visit.getNextSurvey());
        updatedVisit.setPropertyStatus(visit.getPropertyStatus());
        visitRepo.save(updatedVisit);
        return ResponseEntity.ok(updatedVisit);
    }

    @DeleteMapping(value = "/deleteasset/{assetID}")
    public String deleteAsset(@PathVariable long assetID) {
        AssetDetails deleteAsset = assetRepo.findById(assetID).get();
        assetRepo.delete(deleteAsset);
        return "Deleted asset";
    }
    @DeleteMapping(value = "/deletevisit/{visitID}")
    public String deleteVisit(@PathVariable long visitID) {
        VisitDetails deleteVisit = visitRepo.findById(visitID).get();
        visitRepo.delete(deleteVisit);
        return "Deleted visit";
    }

    @RequestMapping(path = "/visitdate/{myStart}/{myEnd}", method = RequestMethod.GET)
    public ResponseEntity<List<VisitDetails>> getBetweenDates(@PathVariable Date myStart, @PathVariable Date myEnd){
        List<VisitDetails> Visits = visitRepo.findBetweenDates(myStart, myEnd);
        return ResponseEntity.ok(Visits);
    }
}
