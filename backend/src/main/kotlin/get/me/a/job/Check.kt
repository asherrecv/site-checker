package get.me.a.job

import get.me.a.job.dao.Dao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.net.URL

private val LOGGER = KotlinLogging.logger { }

fun checkTask(dao: Dao) {
    LOGGER.info { "checking sites" }
    val sites = dao.getSites()
    val updated =
        runBlocking {
            sites
                .map { site ->
                    val newStatus = async(Dispatchers.IO) {
                        try {
                            LOGGER.info { site.url }
                            URL(site.url).content
                            true
                        } catch (t: Throwable) {
                            false
                        }
                    }
                    site to newStatus
                }
                .map { (site, deferredStatus) -> site to deferredStatus.await() }
        }
    updated.forEach { (site, newStatus) ->
        dao.updateState(site.id, newStatus)
    }
}
