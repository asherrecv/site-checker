package get.me.a.job.api


interface SiteFields {
    val url: String
    val up: Boolean
}

interface SiteRow : SiteFields {
    val id: Int
}

data class SiteRowImpl(
    override val id: Int,
    override val url: String,
    override val up: Boolean
) : SiteRow

data class SiteFieldsImpl(
    override val url: String,
    override val up: Boolean
) : SiteFields