package get.me.a.job

import get.me.a.job.api.siteApi
import get.me.a.job.dao.MapDao
import org.http4k.server.SunHttp
import org.http4k.server.asServer


fun main() {
    siteApi(MapDao()).asServer(SunHttp(9000)).start()
}
