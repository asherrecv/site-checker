package get.me.a.job.dao

import get.me.a.job.api.SiteFields
import get.me.a.job.api.SiteRow
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

private data class SiteState(
    val site: SiteFields,
    val up: Boolean
)

class MapDao : Dao {

    private val nextId = AtomicInteger(0)
    private val map = ConcurrentHashMap<Int, SiteState>()

    override fun getSites(): List<SiteRow> {
        return map.map { (id, site) -> SiteRow(id, site.site.url, site.up) }
    }

    override fun getSite(id: Int): SiteRow? {
        return map[id]?.let { state -> SiteRow(id, state.site.url, state.up) }
    }

    override fun addSite(site: SiteFields) {
        map[nextId.incrementAndGet()] = SiteState(site, up = false)
    }

    override fun updateSite(id: Int, site: SiteFields): Boolean {
        return if (!map.containsKey(id)) {
            false
        } else {
            map[id] = SiteState(site, up = false)
            true
        }
    }

    override fun deleteSite(id: Int): Boolean {
        return if (!map.containsKey(id)) {
            false
        } else {
            map.remove(id)
            true
        }
    }

    override fun updateState(id: Int, up: Boolean) {
        val oldValue = map[id] ?: return
        map[id] = oldValue.copy(up = up)
    }
}