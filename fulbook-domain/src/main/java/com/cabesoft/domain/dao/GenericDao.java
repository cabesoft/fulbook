package com.cabesoft.domain.dao;

import java.io.Serializable;

public interface GenericDao<T> {
	Serializable save(T newInstance);
	void update(T instance);
	void remove(T instance);
	T get(Integer id);

}
