package com.example.holybible.data.chapters

import com.example.holybible.data.chapters.cache.ChaptersCacheDataSource
import com.example.holybible.data.chapters.cache.ChaptersCacheMapper
import com.example.holybible.data.chapters.cloud.ChaptersCloudMapper

interface ChaptersRepository {
   suspend fun fetchChapters(bookID: Int) : ChaptersData

    class Base(
        private val cloudDataSource: ChaptersCloudDataSource,
        private val cacheDataSource: ChaptersCacheDataSource,
        private val cloudMapper: ChaptersCloudMapper,
        private val cacheMapper: ChaptersCacheMapper
    ) : ChaptersRepository{
        override suspend fun fetchChapters(bookID: Int): ChaptersData = try {
            val chaptersCacheList = cacheDataSource.fetchChapters(bookID)
            if (chaptersCacheList.isEmpty()){
                val chaptersCloudList = cloudDataSource.fetchChapters(bookID)
                val chapters = cloudMapper.map(chaptersCloudList,bookID)
                cacheDataSource.saveChapters(bookID,chapters)
                ChaptersData.Success(chapters)
            }else{
                ChaptersData.Success(cacheMapper.map(chaptersCacheList))
            }

        }catch (e: Exception){
            ChaptersData.Fail(e)
        }
    }
}