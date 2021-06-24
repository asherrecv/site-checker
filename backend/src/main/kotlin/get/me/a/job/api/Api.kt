package get.me.a.job.api

import get.me.a.job.dao.Dao
import mu.KotlinLogging
import org.http4k.core.Body
import org.http4k.core.HttpHandler
import org.http4k.core.Method.DELETE
import org.http4k.core.Method.GET
import org.http4k.core.Method.POST
import org.http4k.core.Method.PUT
import org.http4k.core.Response
import org.http4k.core.Status.Companion.CREATED
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK
import org.http4k.core.with
import org.http4k.format.Jackson.auto
import org.http4k.lens.Path
import org.http4k.lens.int
import org.http4k.routing.bind
import org.http4k.routing.routes

private val LOGGER = KotlinLogging.logger {  }

object Lenses {
    val siteRow = Body.auto<SiteRow>().toLens()
    val sitesRows = Body.auto<List<SiteRow>>().toLens()
    val siteFields = Body.auto<SiteFields>().toLens()
    val id = Path.int().of("id")
}

fun siteApi(dao: Dao): HttpHandler {
    return routes(
        "/sites" bind GET to { _ ->
            LOGGER.info { "GET /sites" }
            val rows = dao.getSites()
            Response(OK).with(Lenses.sitesRows of rows)
        },
        "/sites/" bind POST to { request ->
            LOGGER.info { "POST /sites" }
            val site = Lenses.siteFields.extract(request)
            dao.addSite(site)
            Response(CREATED)
        },
        "/sites/{id}" bind PUT to { request ->
            val id = Lenses.id(request)
            LOGGER.info { "PUT /sites/$id" }
            val site = Lenses.siteFields.extract(request)
            val success = dao.updateSite(id, site)
            if (success) {
                Response(OK)
            } else {
                Response(NOT_FOUND)
            }
        },
        "/sites/{id}" bind DELETE to { request ->
            val id = Lenses.id(request)
            LOGGER.info { "DELETE /sites/$id" }
            val success = dao.deleteSite(id)
            if (success) {
                Response(OK)
            } else {
                Response(NOT_FOUND)
            }
        },
    )
}
