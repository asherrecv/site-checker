package com.example


interface SiteFields {
    val url: String
    val status: String
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