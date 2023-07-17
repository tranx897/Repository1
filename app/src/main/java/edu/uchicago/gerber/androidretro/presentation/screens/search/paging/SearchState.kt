package edu.uchicago.gerber.androidretro.presentation.screens.search.paging

import androidx.paging.PagingData
import edu.uchicago.gerber.androidretro.data.models.Result
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchOperation: SearchOperation = SearchOperation.INITIAL,
    val data: Flow<PagingData<Result>>? = null
)

enum class SearchOperation { LOADING, INITIAL, DONE }