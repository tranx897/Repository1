package edu.uchicago.gerber.androidretro.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import edu.uchicago.gerber.androidretro.common.Constants
import edu.uchicago.gerber.androidretro.data.repository.ApiProvider
import edu.uchicago.gerber.androidretro.data.repository.MoviesRepository
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.SearchState
import edu.uchicago.gerber.androidretro.data.models.Result
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.MovieSource
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.Paginate
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.SearchOperation
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val moviesRepository: MoviesRepository = MoviesRepository(ApiProvider.moviesApi())

    //////////////////////////////////////////
    // MUTABLE-STATES AND OBSERVABLE STATES
    //////////////////////////////////////////
    private var _queryText = mutableStateOf("")
    val queryText: State<String> = _queryText

    private var _movie = mutableStateOf(Constants.fakeMovie)
    val movie: State<Result> = _movie

    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState


    //////////////////////////////////////////
    // FUNCTIONS
    //////////////////////////////////////////
    fun setMovie(movie: Result) {
        _movie.value = movie
    }

    fun setQueryText(query: String) {
        _queryText.value = query
    }


    fun onSearch() {
        _searchState.value = SearchState(searchOperation = SearchOperation.LOADING)
        viewModelScope.launch {
            _searchState.value = SearchState(
                data = Pager(
                    config = PagingConfig(pageSize = 10, prefetchDistance = 5),
                    pagingSourceFactory = {
                        MovieSource(
                            moviesRepository = moviesRepository,
                            paginateData = Paginate(
                                query = _queryText.value,
                            )
                        )
                    }
                ).flow.cachedIn(viewModelScope),
                searchOperation = SearchOperation.DONE
            )
        }
    }
}
