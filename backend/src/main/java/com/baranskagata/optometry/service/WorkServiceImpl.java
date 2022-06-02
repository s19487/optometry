package com.baranskagata.optometry.service;

import com.baranskagata.optometry.dao.WorkRepository;
import com.baranskagata.optometry.entity.Optometrist;
import com.baranskagata.optometry.entity.Work;
import com.baranskagata.optometry.exception.WorkNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WorkServiceImpl implements  WorkService{

   private final WorkRepository workRepository;


    @Override
    public Work getWorkById(Long id) {
        return workRepository.findById(id).orElseThrow(()-> new WorkNotFoundException("Work does not exist with id: "+ id));
    }

    @Override
    public List<Work> getWorks() {
        return workRepository.findAll();
    }

    @Override
    public Work saveWork(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Work updateWork(Long workId,Work updateWorkData) {
        Work work = workRepository.findById(workId).orElseThrow(()->new WorkNotFoundException("Work does not exist with id:"+ workId));

        work.setName(updateWorkData.getName());
        work.setDescription(updateWorkData.getDescription());
        work.setPrice(updateWorkData.getPrice());
        work.setDuration(updateWorkData.getDuration());
        workRepository.save(work);
        return work;
    }

    @Override
    public void deleteWorkById(Long workId) {
        Work work = workRepository.findById(workId).orElseThrow(()->new WorkNotFoundException("Work does not exist with id:"+ workId));
        workRepository.delete(work);
    }

    @Override
    public List<Work> getWorkByOptometristId(Long optometristId) {
        return workRepository.getWorkByOptometristId(optometristId);
    }
    @Override
    public List<Optometrist> getOptometristForWorkId(Long workId) {
        return workRepository.getOptometristForWorkId(workId);
    }
}
