package edu.uchicago.gerber.androidretro.presentation.screens.search.paging

data class Paginate(
    val name: String  = "",
    val page: Int = 1,
    val limit: Int = 10,
)