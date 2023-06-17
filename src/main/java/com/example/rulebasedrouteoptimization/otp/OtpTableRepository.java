package com.example.rulebasedrouteoptimization.otp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface OtpTableRepository extends JpaRepository<OtpTable,Long>{
    @Query("SELECT otp from OtpTable otp where otp.user.id= :uid AND otp.otp= :otp")
    Optional<OtpTable> verifyOtp(@Param("uid") Integer uid,@Param("otp") String otp);

    @Modifying
    @Transactional
    @Query("DELETE FROM OtpTable otp WHERE otp.user.id= :uid AND otp.otp= :otp")
    void delete(@Param("uid") Integer uid,@Param("otp") String otp);
    @Modifying
    @Transactional
    @Query("DELETE FROM OtpTable e WHERE e.createdTimestamp < :timestamp")
    void deleteByCreatedTimestampBefore(@Param("timestamp") LocalDateTime timestamp);

    @Query("SELECT otp from OtpTable otp where otp.user.id=:uid")
    Optional<OtpTable> presentData(@Param("uid") Integer uid);

    @Modifying
    @Transactional
    @Query("DELETE from OtpTable  otp where otp.user.id=:uid")
    void deltebyId(@Param("uid") Integer uid);
}
