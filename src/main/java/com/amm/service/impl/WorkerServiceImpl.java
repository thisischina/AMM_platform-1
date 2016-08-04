package com.amm.service.impl;

import com.amm.entity.WorkerEntity;
import com.amm.exception.ObjectNotFoundException;
import com.amm.repository.WorkerRepository;
import com.amm.service.WorkerService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by csw on 2016/8/4 12:48.
 * Explain:
 */
@Component("workerService")
@Scope("prototype")
public class WorkerServiceImpl extends BaseService implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Transactional
    public WorkerEntity create(WorkerEntity workerEntity) {

        Validate.notNull(workerEntity, "The workerEntity must not be null, create failure.");
        Validate.notNull(workerEntity.getUserName(), "The userName must not be null, create failure.");
        Validate.notNull(workerEntity.getPassword(), "The password must not be null, create failure.");

        WorkerEntity created = workerRepository.save(workerEntity);

        return created;
    }

    public List<WorkerEntity> findAll() {

        return (List<WorkerEntity>) workerRepository.findAll();
    }

    @Transactional
    public WorkerEntity update(WorkerEntity worker) {

        Validate.notNull(worker.getId(), "The id of worker must not be null, update failure.");
        Validate.notNull(worker, "The worker object must not be null, update failure.");

        WorkerEntity updated = workerRepository.findOne(worker.getId());
        if(updated == null) {
            throw new ObjectNotFoundException("需要更新的农机司机不存在");
        }

        updated = worker.changeUpdateInfoToSave(updated);

        updated = workerRepository.save(updated);

        return updated;
    }

    public WorkerEntity findOne(Integer id) {

        Validate.notNull(id, "The id must not be null, find failure.");

        return workerRepository.findOne(id);
    }

    @Transactional
    public WorkerEntity delete(Integer id) {

        Validate.notNull(id, "The id must not be null, delete failure.");

        WorkerEntity deleted = workerRepository.findOne(id);
        if(deleted == null) {
            throw new ObjectNotFoundException("删除的农机司机不存在");
        }

        workerRepository.delete(id);

        return deleted;
    }
}