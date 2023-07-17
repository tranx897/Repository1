package edu.uchicago.gerber.androidretro.presentation.screens.search.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.uchicago.gerber.androidretro.data.repository.MoviesRepository
import edu.uchicago.gerber.androidretro.data.models.Result
import edu.uchicago.gerber.androidretro.presentation.viewmodels.MovieViewModel


class MovieSource (
    private val moviesRepository: MoviesRepository,
    private val paginateData: Paginate,
    private val movieViewModel: MovieViewModel
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

            val response = moviesRepository.getMovies(
                page = prev,
                limit = params.loadSize,
                name = movieViewModel.queryText.value
            )
            Log.d("Laurence", response.toString())
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