package com.demoproject.repository.membershipManagement;

import com.demoproject.entity.memberManagement.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Members, Long> {

}
