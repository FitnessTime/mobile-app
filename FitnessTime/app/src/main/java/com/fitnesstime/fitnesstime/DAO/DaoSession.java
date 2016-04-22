package com.fitnesstime.fitnesstime.DAO;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.fitnesstime.fitnesstime.Dominio.Ejercicio;
import com.fitnesstime.fitnesstime.Dominio.Rutina;
import com.fitnesstime.fitnesstime.Dominio.SecurityToken;

import com.fitnesstime.fitnesstime.DAO.EjercicioDao;
import com.fitnesstime.fitnesstime.DAO.RutinaDao;
import com.fitnesstime.fitnesstime.DAO.SecurityTokenDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig ejercicioDaoConfig;
    private final DaoConfig rutinaDaoConfig;
    private final DaoConfig securityTokenDaoConfig;

    private final EjercicioDao ejercicioDao;
    private final RutinaDao rutinaDao;
    private final SecurityTokenDao securityTokenDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        ejercicioDaoConfig = daoConfigMap.get(EjercicioDao.class).clone();
        ejercicioDaoConfig.initIdentityScope(type);

        rutinaDaoConfig = daoConfigMap.get(RutinaDao.class).clone();
        rutinaDaoConfig.initIdentityScope(type);

        securityTokenDaoConfig = daoConfigMap.get(SecurityTokenDao.class).clone();
        securityTokenDaoConfig.initIdentityScope(type);

        ejercicioDao = new EjercicioDao(ejercicioDaoConfig, this);
        rutinaDao = new RutinaDao(rutinaDaoConfig, this);
        securityTokenDao = new SecurityTokenDao(securityTokenDaoConfig, this);

        registerDao(Ejercicio.class, ejercicioDao);
        registerDao(Rutina.class, rutinaDao);
        registerDao(SecurityToken.class, securityTokenDao);
    }
    
    public void clear() {
        ejercicioDaoConfig.getIdentityScope().clear();
        rutinaDaoConfig.getIdentityScope().clear();
        securityTokenDaoConfig.getIdentityScope().clear();
    }

    public EjercicioDao getEjercicioDao() {
        return ejercicioDao;
    }

    public RutinaDao getRutinaDao() {
        return rutinaDao;
    }

    public SecurityTokenDao getSecurityTokenDao() {
        return securityTokenDao;
    }

}
