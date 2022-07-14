package com.example.holybible.core

import android.app.Application
import com.example.holybible.data.books.BooksRepository
import com.example.holybible.data.books.ToBookMapper
import com.example.holybible.data.books.cache.BookDataToDbMapper
import com.example.holybible.data.books.cache.BooksCacheDataSource
import com.example.holybible.data.books.cache.BooksCacheMapper
import com.example.holybible.data.books.cloud.BooksCloudDataSource
import com.example.holybible.data.books.cloud.BooksCloudMapper
import com.example.holybible.data.books.cloud.BooksService
import com.example.holybible.data.chapters.ChapterIdToUiMapper
import com.example.holybible.data.chapters.ChaptersRepository
import com.example.holybible.data.chapters.ToChapterMapper
import com.example.holybible.data.chapters.cache.ChapterDataToDbMapper
import com.example.holybible.data.chapters.cache.ChaptersCacheDataSource
import com.example.holybible.data.chapters.cache.ChaptersCacheMapper
import com.example.holybible.data.chapters.cloud.ChaptersCloudDataSource
import com.example.holybible.data.chapters.cloud.ChaptersCloudMapper
import com.example.holybible.data.chapters.cloud.ChaptersService
import com.example.holybible.domain.books.BaseBookDataToDomainMapper
import com.example.holybible.domain.books.BaseBooksDataToDomainMapper
import com.example.holybible.domain.books.BooksInteractor
import com.example.holybible.domain.chapters.BaseChapterDataToDomainMapper
import com.example.holybible.domain.chapters.BaseChaptersDataToDomainMapper
import com.example.holybible.domain.chapters.ChaptersInteractor
import com.example.holybible.presentation.MainViewModel
import com.example.holybible.presentation.NavigationCommunication
import com.example.holybible.presentation.Navigator
import com.example.holybible.presentation.books.*
import com.example.holybible.presentation.chapters.BaseChapterDomainToUiMapper
import com.example.holybible.presentation.chapters.BaseChaptersDomainToUiMapper
import com.example.holybible.presentation.chapters.ChaptersCommunication
import com.example.holybible.presentation.chapters.ChaptersViewModel
import com.google.gson.Gson
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


class BibleApp : Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel
    lateinit var booksViewModel: BooksViewModel
    lateinit var chaptersViewModel: ChaptersViewModel

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        val service = retrofit.create(BooksService::class.java)

        val gson = Gson()
        val cloudDataSource = BooksCloudDataSource.Base(service, gson)
        val realmProvider = RealmProvider.Base()
        val cacheDataSource =
            BooksCacheDataSource.Base(realmProvider, BookDataToDbMapper.Base())
        val toBookMapper = ToBookMapper.Base()
        val booksCloudMapper = BooksCloudMapper.Base(toBookMapper)
        val booksCacheMapper = BooksCacheMapper.Base(toBookMapper)
        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val booksInteractor = BooksInteractor.Base(
            booksRepository,
            BaseBooksDataToDomainMapper(BaseBookDataToDomainMapper())
        )
        val communication = BooksCommunication.Base()
        val resourceProvider = ResourceProvider.Base(this)
        val bookCache = BookCache.Base(this)
        val chaptersRepository = ChaptersRepository.Base(
            ChaptersCloudDataSource.Base(
                retrofit.create(ChaptersService::class.java),
                gson
            ),
            ChaptersCacheDataSource.Base(realmProvider, ChapterDataToDbMapper.Base()),
            ChaptersCloudMapper.Base(ToChapterMapper.Cloud(bookCache)),
            ChaptersCacheMapper.Base(ToChapterMapper.Db(bookCache)),
            bookCache
        )
        val chaptersInteractor = ChaptersInteractor.Base(
            chaptersRepository,
            BaseChaptersDataToDomainMapper(BaseChapterDataToDomainMapper())
        )

        val navigator = Navigator.Base(this)
        val navigationCommunication = NavigationCommunication.Base()
        mainViewModel = MainViewModel(navigator, navigationCommunication)

        booksViewModel = BooksViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(resourceProvider, BaseBookDomainToUiMapper(resourceProvider)),
            communication,
            UiDataCache.Base(CollapsedIdsCache.Base(this)),
            bookCache,
            navigator,
            navigationCommunication
        )

        chaptersViewModel = ChaptersViewModel(
            chaptersInteractor,
            ChaptersCommunication.Base(),
            BaseChaptersDomainToUiMapper(
                BaseChapterDomainToUiMapper(ChapterIdToUiMapper.Base(resourceProvider)),
                resourceProvider
            ),
            navigator,
            bookCache
        )
    }
}