package edu.uchicago.gerber.androidretro.presentation.viewmodels

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import edu.uchicago.gerber.androidretro.common.Constants
import edu.uchicago.gerber.androidretro.data.dto.Email
import edu.uchicago.gerber.androidretro.data.dto.Movie
import edu.uchicago.gerber.androidretro.data.repository.ApiProvider
import edu.uchicago.gerber.androidretro.data.repository.MoviesRepository
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.SearchState
import edu.uchicago.gerber.androidretro.data.models.Result
import edu.uchicago.gerber.androidretro.data.repository.FavoriteMoviesRepository
import edu.uchicago.gerber.androidretro.data.repository.SamEmailerRepository
import edu.uchicago.gerber.androidretro.presentation.screens.favorites.paging.FavoritesSearchState
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.MovieSource
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.Paginate
import edu.uchicago.gerber.androidretro.presentation.screens.search.paging.SearchOperation
import kotlinx.coroutines.launch
import org.json.JSONObject

class MovieViewModel : ViewModel() {

    private val moviesRepository: MoviesRepository = MoviesRepository(ApiProvider.moviesApi())
    private val samEmailerRepository: SamEmailerRepository = SamEmailerRepository(ApiProvider.samEmailerApi())
    private val favoriteMoviesRepository: FavoriteMoviesRepository = FavoriteMoviesRepository(ApiProvider.favoriteMoviesApi())

    //////////////////////////////////////////
    // MUTABLE-STATES AND OBSERVABLE STATES
    //////////////////////////////////////////
    private var _queryText = mutableStateOf("")
    val queryText: State<String> = _queryText

    private var _movie = mutableStateOf(Constants.fakeMovie)
    val movie: State<Result> = _movie

    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

    private var _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private var _subjectText = mutableStateOf("")
    val subjectText: State<String> = _subjectText

    private var _bodyText = mutableStateOf("")
    val bodyText: State<String> = _bodyText

    private var _favoriteMovie = mutableStateOf(Constants.fakeFavoriteMovie)
    val favoriteMovie: State<Movie> = _favoriteMovie

    private val _favoritesSearchState = mutableStateOf(FavoritesSearchState())
    val favoritesSearchState: State<FavoritesSearchState> = _favoritesSearchState



    //////////////////////////////////////////
    // FUNCTIONS
    //////////////////////////////////////////
    fun setMovie(movie: Result) {
        _movie.value = movie
    }

    fun setQueryText(query: String) {
        _queryText.value = query
    }

    fun setEmailText(email: String) {
        _emailText.value = email
    }

    fun setSubjectText(subject: String) {
        _subjectText.value = subject
    }
    fun setBodyText(body: String) {
        _bodyText.value = body
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
                                name = _queryText.value,
                            )
                        )
                    }
                ).flow.cachedIn(viewModelScope),
                searchOperation = SearchOperation.DONE
            )
        }
    }

    fun onSendEmail() {
        val email: Email = Email.string2Email(_emailText.value, _subjectText.value, _bodyText.value)
        val emailJson: JSONObject = email.toJsonRaw()
        viewModelScope.launch {
            samEmailerRepository.sendEmail(emailJson)
        }
    }

    fun onFavoriteSearch() {

    }

}
