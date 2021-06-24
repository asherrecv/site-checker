package get.me.a.job

import get.me.a.job.api.siteApi
import get.me.a.job.dao.MapDao
import org.http4k.core.then
import org.http4k.filter.CorsPolicy
import org.http4k.filter.ServerFilters
import org.http4k.server.SunHttp
import org.http4k.server.asServer
import kotlin.concurrent.thread

fun main() {
    val dao = MapDao()
    thread {
        while (true) {
            checkTask(dao)
            Thread.sleep(1500L)
        }
    }
    ServerFilters.Cors(CorsPolicy.UnsafeGlobalPermissive)
        .then(siteApi(dao))
        .asServer(SunHttp(9000)).start()
}
