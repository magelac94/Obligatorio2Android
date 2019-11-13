package com.diegomedina.notesapp

import android.content.Context
import com.diegomedina.notesapp.data.helper.networking.NetworkingManager
import com.diegomedina.notesapp.data.repository.notes.CloudPeliculasDataStore
import com.diegomedina.notesapp.data.repository.notes.DatabasePeliculasDataStore
import com.diegomedina.notesapp.mocks.NetworkingManagerMock
import com.diegomedina.notesapp.mocks.NoteDaoMock
import com.diegomedina.notesapp.mocks.NotesDataStoreFactoryMock
import com.diegomedina.notesapp.mocks.NotesServiceMock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NotesDataTest {

    @Mock
    private lateinit var mockContext: Context

    lateinit var noteServiceMock: NotesServiceMock
    lateinit var noteDaoMock: NoteDaoMock
    lateinit var networkingManagerMock: NetworkingManagerMock
    lateinit var notesDataStoreFactoryMock: NotesDataStoreFactoryMock

    @Before
    fun beforeTest() {
        noteServiceMock = NotesServiceMock()
        noteDaoMock = NoteDaoMock()
        networkingManagerMock = NetworkingManagerMock(mockContext)
        notesDataStoreFactoryMock =
            NotesDataStoreFactoryMock(noteServiceMock, noteDaoMock, networkingManagerMock)
    }

    @After
    fun afterTest() {

    }


    @Test
    fun testCloudSourceDataRetrieving() {
        networkingManagerMock.networkingAvailable = true

        assert(notesDataStoreFactoryMock.notesDataStoreFactory is CloudPeliculasDataStore)
    }

    @Test
    fun testDatabaseSourceDataRetrieving() {
        networkingManagerMock.networkingAvailable = false

        assert(notesDataStoreFactoryMock.notesDataStoreFactory is DatabasePeliculasDataStore)
    }

    @Test
    fun testNetworking() {
        val networkingManager = NetworkingManager(mockContext)
        assert(networkingManager.isNetworkOnline())
    }

    @Test
    fun testSourceData() {

    }

}
