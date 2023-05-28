package com.example.a8week

import androidx.room.*

@Dao
abstract class MemoDao {

    @Query(value = "select * from memo") //만들어진 순서대로
    abstract fun querySelectAllDefault(): List<Memo>

    @Query("select * from memo order by id desc") //최근날짜
    abstract fun querySelectAllOrderByLast(): List<Memo>

    @Query("select * from memo order by modified") //변경된 순서대로
    abstract fun querySelectAllOrderByModified(): List<Memo>

    @Query("insert into memo(title,content) values(:title,:content)")
    abstract fun insert(title: String, content: String)

//    @Query("insert into memo(title,content) values(:title,:content)")
//    abstract fun insert(title: String, content: String)

//    @Insert(onConflict = REPLACE)
//    abstract fun insert(memo: Memo)

    @Delete()
    abstract fun delete(memo: Memo)

    @Update()
    abstract fun update(memo: Memo)
}