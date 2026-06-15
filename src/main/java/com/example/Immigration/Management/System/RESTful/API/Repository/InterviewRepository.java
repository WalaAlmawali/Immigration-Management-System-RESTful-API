package com.example.Immigration.Management.System.RESTful.API.Repository;

import com.example.Immigration.Management.System.RESTful.API.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository  extends JpaRepository<Interview, Long> {

    List<Interview> findByOfficerIdAndInterviewDate(Long officerId, String interviewDate);
    List<Interview> findByApplicantId(Long applicantId);

}
