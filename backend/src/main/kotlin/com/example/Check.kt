package com.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.net.URI
import java.net.URL

fun checkTask(dao: Dao) {
    val sites = dao.getSites()

    runBlocking(Dispatchers.IO) {
       sites.map {
           async {
               URL()
           }
       }
    }
}