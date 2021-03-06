package com.fitnesstime.fitnesstime.DAO;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.fitnesstime.fitnesstime.Dominio.Ejercicio;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "EJERCICIO".
*/
public class EjercicioDao extends AbstractDao<Ejercicio, Long> {

    public static final String TABLENAME = "EJERCICIO";

    /**
     * Properties of entity Ejercicio.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property IdWeb = new Property(1, Long.class, "idWeb", false, "ID_WEB");
        public final static Property VersionWeb = new Property(2, Integer.class, "versionWeb", false, "VERSION_WEB");
        public final static Property Version = new Property(3, Integer.class, "version", false, "VERSION");
        public final static Property Nombre = new Property(4, String.class, "nombre", false, "NOMBRE");
        public final static Property EstaSincronizado = new Property(5, boolean.class, "estaSincronizado", false, "ESTA_SINCRONIZADO");
        public final static Property DiaDeLaSemana = new Property(6, String.class, "diaDeLaSemana", false, "DIA_DE_LA_SEMANA");
        public final static Property Series = new Property(7, Integer.class, "series", false, "SERIES");
        public final static Property Repeticiones = new Property(8, Integer.class, "repeticiones", false, "REPETICIONES");
        public final static Property TiempoActivo = new Property(9, Integer.class, "tiempoActivo", false, "TIEMPO_ACTIVO");
        public final static Property TiempoDescanso = new Property(10, Integer.class, "tiempoDescanso", false, "TIEMPO_DESCANSO");
        public final static Property NombreCambio = new Property(11, Boolean.class, "nombreCambio", false, "NOMBRE_CAMBIO");
        public final static Property DiaDeLaSemanaCambio = new Property(12, Boolean.class, "diaDeLaSemanaCambio", false, "DIA_DE_LA_SEMANA_CAMBIO");
        public final static Property SeriesCambio = new Property(13, Boolean.class, "seriesCambio", false, "SERIES_CAMBIO");
        public final static Property RepeticionesCambio = new Property(14, Boolean.class, "repeticionesCambio", false, "REPETICIONES_CAMBIO");
        public final static Property TiempoActivoCambio = new Property(15, Boolean.class, "tiempoActivoCambio", false, "TIEMPO_ACTIVO_CAMBIO");
        public final static Property TiempoDescansoCambio = new Property(16, Boolean.class, "tiempoDescansoCambio", false, "TIEMPO_DESCANSO_CAMBIO");
        public final static Property Eliminada = new Property(17, boolean.class, "eliminada", false, "ELIMINADA");
        public final static Property EsDeCarga = new Property(18, boolean.class, "esDeCarga", false, "ES_DE_CARGA");
        public final static Property RutinaId = new Property(19, long.class, "rutinaId", false, "RUTINA_ID");
    };

    private DaoSession daoSession;

    private Query<Ejercicio> rutina_EjercicioListQuery;

    public EjercicioDao(DaoConfig config) {
        super(config);
    }
    
    public EjercicioDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"EJERCICIO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"ID_WEB\" INTEGER," + // 1: idWeb
                "\"VERSION_WEB\" INTEGER," + // 2: versionWeb
                "\"VERSION\" INTEGER," + // 3: version
                "\"NOMBRE\" TEXT NOT NULL ," + // 4: nombre
                "\"ESTA_SINCRONIZADO\" INTEGER NOT NULL ," + // 5: estaSincronizado
                "\"DIA_DE_LA_SEMANA\" TEXT," + // 6: diaDeLaSemana
                "\"SERIES\" INTEGER," + // 7: series
                "\"REPETICIONES\" INTEGER," + // 8: repeticiones
                "\"TIEMPO_ACTIVO\" INTEGER," + // 9: tiempoActivo
                "\"TIEMPO_DESCANSO\" INTEGER," + // 10: tiempoDescanso
                "\"NOMBRE_CAMBIO\" INTEGER," + // 11: nombreCambio
                "\"DIA_DE_LA_SEMANA_CAMBIO\" INTEGER," + // 12: diaDeLaSemanaCambio
                "\"SERIES_CAMBIO\" INTEGER," + // 13: seriesCambio
                "\"REPETICIONES_CAMBIO\" INTEGER," + // 14: repeticionesCambio
                "\"TIEMPO_ACTIVO_CAMBIO\" INTEGER," + // 15: tiempoActivoCambio
                "\"TIEMPO_DESCANSO_CAMBIO\" INTEGER," + // 16: tiempoDescansoCambio
                "\"ELIMINADA\" INTEGER NOT NULL ," + // 17: eliminada
                "\"ES_DE_CARGA\" INTEGER NOT NULL ," + // 18: esDeCarga
                "\"RUTINA_ID\" INTEGER NOT NULL );"); // 19: rutinaId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"EJERCICIO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Ejercicio entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long idWeb = entity.getIdWeb();
        if (idWeb != null) {
            stmt.bindLong(2, idWeb);
        }
 
        Integer versionWeb = entity.getVersionWeb();
        if (versionWeb != null) {
            stmt.bindLong(3, versionWeb);
        }
 
        Integer version = entity.getVersion();
        if (version != null) {
            stmt.bindLong(4, version);
        }
        stmt.bindString(5, entity.getNombre());
        stmt.bindLong(6, entity.getEstaSincronizado() ? 1L: 0L);
 
        String diaDeLaSemana = entity.getDiaDeLaSemana();
        if (diaDeLaSemana != null) {
            stmt.bindString(7, diaDeLaSemana);
        }
 
        Integer series = entity.getSeries();
        if (series != null) {
            stmt.bindLong(8, series);
        }
 
        Integer repeticiones = entity.getRepeticiones();
        if (repeticiones != null) {
            stmt.bindLong(9, repeticiones);
        }
 
        Integer tiempoActivo = entity.getTiempoActivo();
        if (tiempoActivo != null) {
            stmt.bindLong(10, tiempoActivo);
        }
 
        Integer tiempoDescanso = entity.getTiempoDescanso();
        if (tiempoDescanso != null) {
            stmt.bindLong(11, tiempoDescanso);
        }
 
        Boolean nombreCambio = entity.getNombreCambio();
        if (nombreCambio != null) {
            stmt.bindLong(12, nombreCambio ? 1L: 0L);
        }
 
        Boolean diaDeLaSemanaCambio = entity.getDiaDeLaSemanaCambio();
        if (diaDeLaSemanaCambio != null) {
            stmt.bindLong(13, diaDeLaSemanaCambio ? 1L: 0L);
        }
 
        Boolean seriesCambio = entity.getSeriesCambio();
        if (seriesCambio != null) {
            stmt.bindLong(14, seriesCambio ? 1L: 0L);
        }
 
        Boolean repeticionesCambio = entity.getRepeticionesCambio();
        if (repeticionesCambio != null) {
            stmt.bindLong(15, repeticionesCambio ? 1L: 0L);
        }
 
        Boolean tiempoActivoCambio = entity.getTiempoActivoCambio();
        if (tiempoActivoCambio != null) {
            stmt.bindLong(16, tiempoActivoCambio ? 1L: 0L);
        }
 
        Boolean tiempoDescansoCambio = entity.getTiempoDescansoCambio();
        if (tiempoDescansoCambio != null) {
            stmt.bindLong(17, tiempoDescansoCambio ? 1L: 0L);
        }
        stmt.bindLong(18, entity.getEliminada() ? 1L: 0L);
        stmt.bindLong(19, entity.getEsDeCarga() ? 1L: 0L);
        stmt.bindLong(20, entity.getRutinaId());
    }

    @Override
    protected void attachEntity(Ejercicio entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Ejercicio readEntity(Cursor cursor, int offset) {
        Ejercicio entity = new Ejercicio( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // idWeb
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // versionWeb
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // version
            cursor.getString(offset + 4), // nombre
            cursor.getShort(offset + 5) != 0, // estaSincronizado
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // diaDeLaSemana
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // series
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // repeticiones
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // tiempoActivo
            cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10), // tiempoDescanso
            cursor.isNull(offset + 11) ? null : cursor.getShort(offset + 11) != 0, // nombreCambio
            cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0, // diaDeLaSemanaCambio
            cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0, // seriesCambio
            cursor.isNull(offset + 14) ? null : cursor.getShort(offset + 14) != 0, // repeticionesCambio
            cursor.isNull(offset + 15) ? null : cursor.getShort(offset + 15) != 0, // tiempoActivoCambio
            cursor.isNull(offset + 16) ? null : cursor.getShort(offset + 16) != 0, // tiempoDescansoCambio
            cursor.getShort(offset + 17) != 0, // eliminada
            cursor.getShort(offset + 18) != 0, // esDeCarga
            cursor.getLong(offset + 19) // rutinaId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Ejercicio entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIdWeb(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setVersionWeb(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setVersion(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setNombre(cursor.getString(offset + 4));
        entity.setEstaSincronizado(cursor.getShort(offset + 5) != 0);
        entity.setDiaDeLaSemana(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSeries(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setRepeticiones(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setTiempoActivo(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setTiempoDescanso(cursor.isNull(offset + 10) ? null : cursor.getInt(offset + 10));
        entity.setNombreCambio(cursor.isNull(offset + 11) ? null : cursor.getShort(offset + 11) != 0);
        entity.setDiaDeLaSemanaCambio(cursor.isNull(offset + 12) ? null : cursor.getShort(offset + 12) != 0);
        entity.setSeriesCambio(cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0);
        entity.setRepeticionesCambio(cursor.isNull(offset + 14) ? null : cursor.getShort(offset + 14) != 0);
        entity.setTiempoActivoCambio(cursor.isNull(offset + 15) ? null : cursor.getShort(offset + 15) != 0);
        entity.setTiempoDescansoCambio(cursor.isNull(offset + 16) ? null : cursor.getShort(offset + 16) != 0);
        entity.setEliminada(cursor.getShort(offset + 17) != 0);
        entity.setEsDeCarga(cursor.getShort(offset + 18) != 0);
        entity.setRutinaId(cursor.getLong(offset + 19));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Ejercicio entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Ejercicio entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "ejercicioList" to-many relationship of Rutina. */
    public List<Ejercicio> _queryRutina_EjercicioList(long rutinaId) {
        synchronized (this) {
            if (rutina_EjercicioListQuery == null) {
                QueryBuilder<Ejercicio> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.RutinaId.eq(null));
                rutina_EjercicioListQuery = queryBuilder.build();
            }
        }
        Query<Ejercicio> query = rutina_EjercicioListQuery.forCurrentThread();
        query.setParameter(0, rutinaId);
        return query.list();
    }

}
