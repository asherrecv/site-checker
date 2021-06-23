package com.example

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

interface Dao {
    fun getSites(): List<SiteRow>
    fun addSite(site: SiteFields)
    fun updateSite(id: Int, site: SiteFields): Boolean
    fun deleteSite(id: Int): Boolean
}


