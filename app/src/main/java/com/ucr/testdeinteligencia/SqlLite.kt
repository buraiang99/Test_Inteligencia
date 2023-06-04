package com.ucr.testdeinteligencia

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqlLite(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "testInteligencia.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_INTE = "inteligencia"
        private const val COLUMN_SCORE = "puntos"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT,$COLUMN_INTE TEXT,$COLUMN_SCORE TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertData(name: String,inte: String,score: Int) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_INTE, inte)
        values.put(COLUMN_SCORE, score)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllData(): List<Map<String, Any>> {
        val db = readableDatabase
        val consulta = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(consulta, null)
        val dataList = mutableListOf<Map<String, Any>>()

        while (cursor.moveToNext()) {
            val columnNames = cursor.columnNames
            val data = HashMap<String, Any>()

            for (columnName in columnNames) {
                val value = cursor.getString(cursor.getColumnIndex(columnName))
                data[columnName] = value
            }

            dataList.add(data)
        }
        cursor.close()
        db.close()
        return dataList
    }
    @SuppressLint("Range")
    fun getLastUser(): Map<String, Any>? {
        val db = readableDatabase

        val consulta = "SELECT * FROM $TABLE_NAME ORDER BY id DESC LIMIT 1"

        val cursor = db.rawQuery(consulta, null)

        var usuario: Map<String, Any>? = null

        if (cursor.moveToFirst()) {
            val columnNames = cursor.columnNames
            usuario = HashMap<String, Any>()

            for (columnName in columnNames) {
                val value = cursor.getString(cursor.getColumnIndex(columnName))
                usuario[columnName] = value
            }
        }

        cursor.close()
        db.close()

        return usuario
    }

    fun updateUserColumn(id: Int, columnName: String, columnValue: String) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(columnName, columnValue)

        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(id.toString())

        db.update(TABLE_NAME, contentValues, whereClause, whereArgs)
    }
    fun deleteAll() {
        val db = writableDatabase
        db.delete(TABLE_NAME, null, null)
        db.close()
    }
}