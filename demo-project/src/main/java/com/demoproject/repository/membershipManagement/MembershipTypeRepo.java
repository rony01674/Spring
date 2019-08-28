package com.demoproject.repository.membershipManagement;

import com.demoproject.entity.mebershipTypeManagement.MembershipTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepo extends JpaRepository<MembershipTypeEntity, Long> {


}
