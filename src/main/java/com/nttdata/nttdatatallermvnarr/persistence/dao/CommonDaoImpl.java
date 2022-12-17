package com.nttdata.nttdatatallermvnarr.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.nttdatatallermvnarr.persistence.AbstractEntity;

/**
 * 
 * @author Alexandra Rodriguez
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	// METODOS CRUD COMUNES DESARROLLADOS O IMPLEMENTADOS
	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session dataBaseConnection;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.dataBaseConnection = session;
	}
	
	/**
	 * Método para comprobar si la BBDD está abierta y activa y si no lo está se abre conexión.
	 */
	private void openDataBaseConnectionIfNeeded() {
		if (!dataBaseConnection.getTransaction().isActive()) {
			dataBaseConnection.getTransaction().begin();
		}
	}

	@Override
	public void insert(T paramT) {
		// Si la conexión a BBDD no está activa entonces abrimos una.
		openDataBaseConnectionIfNeeded();

		// Guarda paramT en la BBDD
		dataBaseConnection.save(paramT);
		dataBaseConnection.flush();
		// Ejecuta la acción
		dataBaseConnection.getTransaction().commit();
	}

	@Override
	public void update(T paramT) {
		// Si la conexión a BBDD no está activa entonces abrimos una.
		openDataBaseConnectionIfNeeded();

		// Guarda o actualiza paramT en la BBDD
		dataBaseConnection.saveOrUpdate(paramT);
		// Ejecuta la acción
		dataBaseConnection.getTransaction().commit();
	}

	@Override
	public void delete(T paramT) {
		// Si la conexión a BBDD no está activa entonces abrimos una.
		openDataBaseConnectionIfNeeded();

		// Borra paramT en la BBDD
		dataBaseConnection.delete(paramT);
		// Ejecuta la acción
		dataBaseConnection.getTransaction().commit();
	}

	@Override
	public T searchById(Long id) {
		// Si la conexión a BBDD no está activa entonces abrimos una.
		openDataBaseConnectionIfNeeded();

		// Devuelve de la BBDD el paramT que coincida con el id pasado por parámetro.
		T result = dataBaseConnection.get(this.entityClass, id);

		return result;
	}

	@Override
	public List<T> searchAll() {
		// Si la conexión a BBDD no está activa entonces abrimos una.
		openDataBaseConnectionIfNeeded();

		// SELECT * FROM T
		// Devuelve de la BBDD una lista completa de la tabla entityClass que será del tipo T.
		List<T> list = dataBaseConnection.createQuery("FROM " + this.entityClass.getName()).list();

		return list;
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
