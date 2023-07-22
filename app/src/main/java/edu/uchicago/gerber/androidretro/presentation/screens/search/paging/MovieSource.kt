package edu.uchicago.gerber.androidretro.presentation.screens.search.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.uchicago.gerber.androidretro.data.repository.MoviesRepository
import edu.uchicago.gerber.androidretro.data.models.Result
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel


class MovieSource (
    private val moviesRepository: MoviesRepository,
    private val paginateData : Paginate
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
            val nextPageNumber = params.key ?: 1

            val response = moviesRepository.getMovies(
                name = paginateData.name, page = nextPageNumber
            )
            if (response.isSuccessful) {
                val body = response.body()?.results
                LoadResult.Page(
                    data = body!!,
                    prevKey = if (nextPageNumber == 0) null else nextPageNumber - 1,
                    nextKey = nextPageNumber + 1
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

