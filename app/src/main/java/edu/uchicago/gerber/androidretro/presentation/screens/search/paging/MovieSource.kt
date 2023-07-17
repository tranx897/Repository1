package edu.uchicago.gerber.androidretro.presentation.screens.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.uchicago.gerber.androidretro.data.repository.MoviesRepository
import edu.uchicago.gerber.androidretro.data.models.Result


class MovieSource (
    private val booksRepository: MoviesRepository,
    private val paginateData: Paginate
) :
    PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val prev = params.key ?: 0

            val response = booksRepository.getBooks(
                page = prev,
                limit = params.loadSize,
                query = paginateData.query,
            )

            if (response.isSuccessful) {
                val body = response.body()?.results
                LoadResult.Page(
                    data = body!!,
                    prevKey = if (prev == 0) null else prev - 1,
                    nextKey = if (body.size < params.loadSize) null else prev + 10
                )
            } else {
                LoadResult.Error(Exception(response.message()))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

}