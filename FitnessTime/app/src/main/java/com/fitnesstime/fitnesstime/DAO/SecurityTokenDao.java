package com.fitnesstime.fitnesstime.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.fitnesstime.fitnesstime.Dominio.SecurityToken;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SECURITY_TOKEN".
*/
public class SecurityTokenDao extends AbstractDao<SecurityToken, Long> {

    public static final String TABLENAME = "SECURITY_TOKEN";

    /**
     * Properties of entity SecurityToken.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property NombreUsuario = new Property(1, String.class, "nombreUsuario", false, "NOMBRE_USUARIO");
        public final static Property EmailUsuario = new Property(2, String.class, "emailUsuario", false, "EMAIL_USUARIO");
        public final static Property AuthToken = new Property(3, String.class, "authToken", false, "AUTH_TOKEN");
    };


    public SecurityTokenDao(DaoConfig config) {
        super(config);
    }
    
    public SecurityTokenDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SECURITY_TOKEN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NOMBRE_USUARIO\" TEXT NOT NULL ," + // 1: nombreUsuario
                "\"EMAIL_USUARIO\" TEXT NOT NULL ," + // 2: emailUsuario
                "\"AUTH_TOKEN\" TEXT NOT NULL );"); // 3: authToken
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SECURITY_TOKEN\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SecurityToken entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getNombreUsuario());
        stmt.bindString(3, entity.getEmailUsuario());
        stmt.bindString(4, entity.getAuthToken());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SecurityToken readEntity(Cursor cursor, int offset) {
        SecurityToken entity = new SecurityToken( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // nombreUsuario
            cursor.getString(offset + 2), // emailUsuario
            cursor.getString(offset + 3) // authToken
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SecurityToken entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNombreUsuario(cursor.getString(offset + 1));
        entity.setEmailUsuario(cursor.getString(offset + 2));
        entity.setAuthToken(cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(SecurityToken entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(SecurityToken entity) {
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
    
}