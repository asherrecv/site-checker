package com.example.dao

import com.example.Dao
import com.example.SiteFields
import com.example.SiteRow
import com.example.SiteRowImpl
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

class MapDao : Dao {

    private val nextId = AtomicInteger(0)
    private val map = ConcurrentHashMap<Int, SiteFields>()

    override fun getSites(): List<SiteRow> {
        return map.map { (id, site) -> SiteRowImpl(id, site.url, site.up) }
    }

    override fun addSite(site: SiteFields) {
        map[nextId.incrementAndGet()] = site
    }

    override fun updateSite(id: Int, site: SiteFields): Boolean {
        return if (!map.contains(id)) {
            false
        } else {
            map[id] = site
            true
        }

    }

    override fun deleteSite(id: Int): Boolean {
        return if (!map.contains(id)) {
            false
        } else {
            map.remove(id)
            true
        }
    }
}