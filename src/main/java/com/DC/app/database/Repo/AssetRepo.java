package com.DC.app.database.Repo;

import com.DC.app.database.Models.AssetDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssetRepo extends JpaRepository<AssetDetails, Long> {

}
