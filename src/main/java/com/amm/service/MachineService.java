package com.amm.service;

import com.amm.entity.MachineEntity;

import java.util.List;

/**
 * Created by csw on 2016/8/4 13:11.
 * Explain:
 */
public interface MachineService {
    MachineEntity create(MachineEntity machineEntity);

    List<MachineEntity> findAllByActive(Boolean active);

    MachineEntity update(MachineEntity machine);

    MachineEntity findOne(Integer id);

    MachineEntity delete(Integer id);

    List<MachineEntity> findByOrgId(Integer orgId);

    List<MachineEntity> findByOrgIdAndActive(Integer orgId,Boolean active);

    List<MachineEntity> findByMachCodeAndActive(String checkCode, boolean b);
}
