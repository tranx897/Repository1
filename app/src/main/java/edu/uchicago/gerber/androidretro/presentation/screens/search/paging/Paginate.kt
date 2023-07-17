package edu.uchicago.gerber.androidretro.presentation.screens.search.paging

data class Paginate(
    val query: String = "",
    val limit: Int = 10,
    val page: Int = 1,
)