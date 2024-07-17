package com.example.anr.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MySQLiteOpenHelper(
    context: Context?
) : SQLiteOpenHelper(context, DB_NAME, null, VERSION) {

    companion object {
        const val DB_NAME = "mysqlite.db"
        const val VERSION = 1
    }

    private val CREATE_COURSE = """
        create table if not exists course(
        id integer primary key autoincrement,
        name text,
        teacher text,
        price real
        )
    """.trimIndent()

    private val CREATE_TEACHER = """
        create table if not exists teacher(
        id integer primary key autoincrement,
        name text,
        age integer,
        desc text
        )
    """.trimIndent()

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_COURSE)
        db?.execSQL(CREATE_TEACHER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //TODO 升级
    }
}