package com.hoon.data.inquiry

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hoon.data.inquiry.mapper.mapperToBasedInfoVo
import com.hoon.data.inquiry.mapper.mapperToImageInfoVo
import com.hoon.data.inquiry.repository.remote.InquiryRemoteDataSource
import com.hoon.domain.inquiry.model.BasedInfoVo
import com.hoon.domain.inquiry.model.ImageInfoVo

class ImagePagingSource(private val dataSource: InquiryRemoteDataSource, private val contentId: Int): PagingSource<Int, ImageInfoVo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageInfoVo> {
        return try {
            val next = params.key ?: 1

            LoadResult.Page(
                data = dataSource.getImageList(next, contentId).response.body.items.item.mapperToImageInfoVo(),
                prevKey = if (next == 1) null else next - 1,
                nextKey = next.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ImageInfoVo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}