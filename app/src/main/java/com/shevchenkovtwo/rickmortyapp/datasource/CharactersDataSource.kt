package com.shevchenkovtwo.rickmortyapp.datasource

import androidx.paging.PagingSource
import com.shevchenkovtwo.rickmortyapp.NetworkService
import com.shevchenkovtwo.rickmortyapp.model.Character


class CharactersDataSource(private val networkService: NetworkService
) : PagingSource<Int, Character>()  {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = networkService.getAllCharacters(currentLoadingPageKey)
            val responseData = mutableListOf<Character>()
            val data = response.body()?.characters ?: emptyList()
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