package get.me.a.job.dao

import get.me.a.job.api.SiteFields
import get.me.a.job.api.SiteRow


interface Dao {
    fun getSites(): List<SiteRow>
    fun getSite(id: Int): SiteRow?
    fun addSite(site: SiteFields)
    fun updateSite(id: Int, site: SiteFields): Boolean
    fun deleteSite(id: Int): Boolean
    fun updateState(id:Int, up: Boolean)
}


