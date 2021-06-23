package com.example.dao

import com.example.Dao
import com.example.SiteFields
import com.example.SiteRow
import com.example.SiteRowImpl
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update


class SqlDao : Dao {

    @Suppress("MemberVisibilityCanBePrivate", "SpellCheckingInspection")
    object SiteTable : Table("SITETABLE") {
        val id = integer("id").autoIncrement()
        val url = varchar("url", 255)
        val up = bool("isup")
        override val primaryKey = PrimaryKey(id)
    }

    override fun getSites(): List<SiteRow> {
        return transaction {
            SiteTable.selectAll().map { row ->
                SiteRowImpl(
                    id = row[SiteTable.id],
                    url = row[SiteTable.url],
                    up = row[SiteTable.up]
                )
            }
        }
    }

    override fun addSite(site: SiteFields) {
        transaction {
            SiteTable.insert { row ->
                row[url] = site.url
                row[up] = site.up
            }
        }
    }

    override fun updateSite(id: Int, site: SiteFields): Boolean {
        val rowsAffected = transaction {
            SiteTable.update(where = { SiteTable.id eq id }) { row ->
                row[url] = site.url
                row[up] = site.up
            }
        }
        return (rowsAffected > 0)
    }

    override fun deleteSite(id: Int): Boolean {
        val rowsAffected = transaction {
            SiteTable.deleteWhere { SiteTable.id eq id }
        }
        return (rowsAffected > 0)
    }

}