package com.fitnesstime.fitnesstime.Dominio;

import java.util.List;
import com.fitnesstime.fitnesstime.DAO.DaoSession;
import de.greenrobot.dao.DaoException;

import com.fitnesstime.fitnesstime.DAO.EjercicioDao;
import com.fitnesstime.fitnesstime.DAO.RutinaDao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "RUTINA".
 */
public class Rutina implements DomainEntity {

    private Long id;
    /** Not-null value. */
    private String idUsuario;
    private Integer versionWeb;
    private Integer version;
    private Long idWeb;
    private boolean estaSincronizado;
    private String descripcion;
    private String aclaracion;
    private String inicio;
    private String fin;
    private boolean esDeCarga;
    private boolean eliminada;
    private Boolean inicioCambio;
    private Boolean finCambio;
    private Boolean aclaracionCambio;
    private Boolean descripcionCambio;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RutinaDao myDao;

    private List<Ejercicio> ejercicioList;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Rutina() {
    }

    public Rutina(Long id) {
        this.id = id;
    }

    public Rutina(Long id, String idUsuario, Integer versionWeb, Integer version, Long idWeb, boolean estaSincronizado, String descripcion, String aclaracion, String inicio, String fin, boolean esDeCarga, boolean eliminada, Boolean inicioCambio, Boolean finCambio, Boolean aclaracionCambio, Boolean descripcionCambio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.versionWeb = versionWeb;
        this.version = version;
        this.idWeb = idWeb;
        this.estaSincronizado = estaSincronizado;
        this.descripcion = descripcion;
        this.aclaracion = aclaracion;
        this.inicio = inicio;
        this.fin = fin;
        this.esDeCarga = esDeCarga;
        this.eliminada = eliminada;
        this.inicioCambio = inicioCambio;
        this.finCambio = finCambio;
        this.aclaracionCambio = aclaracionCambio;
        this.descripcionCambio = descripcionCambio;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRutinaDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getIdUsuario() {
        return idUsuario;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getVersionWeb() {
        return versionWeb;
    }

    public void setVersionWeb(Integer versionWeb) {
        this.versionWeb = versionWeb;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getIdWeb() {
        return idWeb;
    }

    public void setIdWeb(Long idWeb) {
        this.idWeb = idWeb;
    }

    public boolean getEstaSincronizado() {
        return estaSincronizado;
    }

    public void setEstaSincronizado(boolean estaSincronizado) {
        this.estaSincronizado = estaSincronizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAclaracion() {
        return aclaracion;
    }

    public void setAclaracion(String aclaracion) {
        this.aclaracion = aclaracion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public boolean getEsDeCarga() {
        return esDeCarga;
    }

    public void setEsDeCarga(boolean esDeCarga) {
        this.esDeCarga = esDeCarga;
    }

    public boolean getEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public Boolean getInicioCambio() {
        return inicioCambio;
    }

    public void setInicioCambio(Boolean inicioCambio) {
        this.inicioCambio = inicioCambio;
    }

    public Boolean getFinCambio() {
        return finCambio;
    }

    public void setFinCambio(Boolean finCambio) {
        this.finCambio = finCambio;
    }

    public Boolean getAclaracionCambio() {
        return aclaracionCambio;
    }

    public void setAclaracionCambio(Boolean aclaracionCambio) {
        this.aclaracionCambio = aclaracionCambio;
    }

    public Boolean getDescripcionCambio() {
        return descripcionCambio;
    }

    public void setDescripcionCambio(Boolean descripcionCambio) {
        this.descripcionCambio = descripcionCambio;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Ejercicio> getEjercicioList() {
        if (ejercicioList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EjercicioDao targetDao = daoSession.getEjercicioDao();
            List<Ejercicio> ejercicioListNew = targetDao._queryRutina_EjercicioList(id);
            synchronized (this) {
                if(ejercicioList == null) {
                    ejercicioList = ejercicioListNew;
                }
            }
        }
        return ejercicioList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetEjercicioList() {
        ejercicioList = null;
    }

    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END
    public boolean nuevaRutina()
    {
        return this.getId()==null;
    }
}
