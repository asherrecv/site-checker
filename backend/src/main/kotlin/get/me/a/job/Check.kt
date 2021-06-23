package get.me.a.job

import get.me.a.job.dao.Dao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.net.URL

fun checkTask(dao: Dao) {
    val sites = dao.getSites()

    runBlocking(Dispatchers.IO) {
       sites.map {
           async {

           }
       }
    }
}