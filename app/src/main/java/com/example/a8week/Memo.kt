package com.example.a8week

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class Memo(

    @PrimaryKey(autoGenerate = true) var id: Long?,

    @ColumnInfo var title: String,
    @ColumnInfo var content: String,

    //CURRENT_TIMESTAMP를 문자열로 넣을 경우
    //defaultValue = "'CURRENT_TIMESTAMP'" <- 실제 문자열이 들어감

    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP") var created: String?,
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP") var modified: String?,

    ) {
    constructor() : this(null, "", "", null, null)
}