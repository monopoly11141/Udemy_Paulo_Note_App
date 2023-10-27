package com.example.udemy_paulo_note_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.udemy_paulo_note_app.screen.NoteScreen
import com.example.udemy_paulo_note_app.screen.NoteViewModel
import com.example.udemy_paulo_note_app.ui.theme.Udemy_Paulo_Note_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Udemy_Paulo_Note_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val noteViewModel: NoteViewModel by viewModels()
                    NoteApp(noteViewModel = noteViewModel)

                }
            }
        }
    }
}

@Composable
fun NoteApp(
    noteViewModel: NoteViewModel
) {

    val noteList = noteViewModel.noteList.collectAsState().value

    NoteScreen(
        notes = noteList,
        onAddNote = { note ->
            noteViewModel.addNote(note)
        },
        onRemoveNote = { note ->
            noteViewModel.removeNote(note)
        }
    )

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Udemy_Paulo_Note_AppTheme {

    }
}