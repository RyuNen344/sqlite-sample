package io.ryunen344.sqlite.sample

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

fun main() {
    println(ClassLoader.getSystemResource("data.db").path)
    val db = Database.connect("jdbc:sqlite:${ClassLoader.getSystemResource("data.db").path}", "org.sqlite.JDBC")
    TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
    transaction {
        val fuga = Members.selectAll().orderBy(Members.id).forEach {
            println(it)
        }
    }
}


object Members : Table() {
    val id = integer("id").autoIncrement()
    val name = text("name")
    val old = integer("old")
    val hoge = bool("hoge")
    val count = integer("count")

    override val primaryKey: PrimaryKey = PrimaryKey(id, name = "PK_Members_Id")
}
