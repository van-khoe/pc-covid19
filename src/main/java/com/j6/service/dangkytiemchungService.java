package com.j6.service;

import java.util.List;

import com.j6.entity.lichtestcd;
import com.j6.entity.nguoitiem;

public interface dangkytiemchungService {

	nguoitiem save(nguoitiem dk);

	List<nguoitiem> findAll();

	List<nguoitiem> findByAccount(String remoteUser);

	nguoitiem findById(Integer id);

	List<Integer> findCountUser();

	List<Integer> findCountM1();

	List<Integer> findCountM2();

	List<Object> findCT();

	List<Object> findM1();

	List<Object> findM2();

	List<Object> findCT1();

}
