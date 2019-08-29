package com.demoproject.repository.membershipManagement;

import com.demoproject.entity.memberManagement.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

    Member findByFileName(String fileName);
}
