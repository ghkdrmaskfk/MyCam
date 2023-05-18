package com.hoon.data.lookup

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hoon.data.lookup.datasource.LookUpRemoteDataSource
import com.hoon.data.lookup.mapper.mapperToCampingBasedInfoVo
import com.hoon.domain.lookup.model.CampingBasedInfoVo

//class PagingSource(private val campingBaseList: List<CampingBasedInfoVo>): PagingSource<Int, CampingBasedInfoVo>() {
class PagingSource(private val dataSource: LookUpRemoteDataSource): PagingSource<Int, CampingBasedInfoVo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CampingBasedInfoVo> {
        return try {
            val next = params.key ?: 1

            LoadResult.Page(
                data = dataSource.getCampingBasedInfo(next).response.body.items.item.mapperToCampingBasedInfoVo(),
                prevKey = if (next == 1) null else next - 1,
                nextKey = next.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CampingBasedInfoVo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}