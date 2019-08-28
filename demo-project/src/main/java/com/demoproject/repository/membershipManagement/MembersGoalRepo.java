package com.demoproject.repository.membershipManagement;

import com.demoproject.entity.mebershipTypeManagement.MemberGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersGoalRepo extends JpaRepository<MemberGoalEntity, Long> {
}
