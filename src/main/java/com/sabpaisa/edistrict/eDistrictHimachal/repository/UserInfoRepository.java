package com.sabpaisa.edistrict.eDistrictHimachal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sabpaisa.edistrict.eDistrictHimachal.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
