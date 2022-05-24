package com.foorun.unieat.pigeon.domain.message.repository;

import com.foorun.unieat.pigeon.domain.message.jpo.MessageJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageJpo, Long> {
}
