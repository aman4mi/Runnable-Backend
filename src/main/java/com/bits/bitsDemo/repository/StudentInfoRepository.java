package com.bits.bitsDemo.repository;

import com.bits.bitsDemo.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by aman.ullah on 3/12/2019.
 */
@Component
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {
}
