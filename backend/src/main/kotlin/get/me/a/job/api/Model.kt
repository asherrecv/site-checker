package get.me.a.job.api

data class SiteFields(
    val url: String
)

data class SiteRow(
    val id: Int,
    val url: String,
    val up: Boolean
)