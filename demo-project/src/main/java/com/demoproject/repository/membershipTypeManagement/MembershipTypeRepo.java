package com.demoproject.repository.membershipTypeManagement;

import com.demoproject.entity.mebershipTypeManagement.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepo extends JpaRepository<MembershipType, Long> {


}
