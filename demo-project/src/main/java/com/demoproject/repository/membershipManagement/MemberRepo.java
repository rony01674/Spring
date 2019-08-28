package com.demoproject.repository.membershipManagement;

import com.demoproject.entity.memberManagement.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByFileName(String fileName);
}
