package com.shevchenkovtwo.rickmortyapp.datasource

import androidx.paging.PagingSource
import com.shevchenkovtwo.rickmortyapp.NetworkService
import com.shevchenkovtwo.rickmortyapp.model.Location


class LocationsDataSource(private val networkService: NetworkService
) : PagingSource<Int, Location>()  {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = networkService.getAllLocations(currentLoadingPageKey)
            val responseData = mutableListOf<Location>()
            val data = response.body()?.locations ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}