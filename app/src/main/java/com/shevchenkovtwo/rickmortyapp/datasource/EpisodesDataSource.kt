package com.shevchenkovtwo.rickmortyapp.datasource

import androidx.paging.PagingSource
import com.shevchenkovtwo.rickmortyapp.NetworkService
import com.shevchenkovtwo.rickmortyapp.model.Episode


class EpisodesDataSource(
    private val networkService: NetworkService
) : PagingSource<Int, Episode>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = networkService.getAllEpisodes(currentLoadingPageKey)
            val responseData = mutableListOf<Episode>()
            val data = response.body()?.episodes ?: emptyList()
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