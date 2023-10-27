package com.example.udemy_paulo_note_app.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemy_paulo_note_app.R
import com.example.udemy_paulo_note_app.components.NoteButton
import com.example.udemy_paulo_note_app.components.NoteInputText
import com.example.udemy_paulo_note_app.data.NotesDataSource
import com.example.udemy_paulo_note_app.model.Note
import com.example.udemy_paulo_note_app.util.formatDateFromLongToString

@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var titleStateValue by remember { mutableStateOf("") }
    var descriptionStateValue by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(6.dp)
    ) {
        TopBar()

        //content
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                text = titleStateValue,
                label = "title : ",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }
                    ) {
                        titleStateValue = it
                    }
                }
            ) {

            }

            NoteInputText(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                text = descriptionStateValue,
                label = "Add a note :",
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }
                    ) {
                        descriptionStateValue = it
                    }
                }
            ) {

            }

            NoteButton(
                text = "save",
                onClick = {
                    if (titleStateValue.isNotEmpty() && descriptionStateValue.isNotEmpty()) {
                        //save & add to list
                        onAddNote(
                            Note(
                                title = titleStateValue,
                                description = descriptionStateValue,
                            )
                        )
                        Toast.makeText(context, "Note Saved", Toast.LENGTH_SHORT).show()
                        titleStateValue = ""
                        descriptionStateValue = ""
                    }
                }
            )

        } //Column

        Divider(
            modifier = Modifier
                .padding(10.dp)
        )

        LazyColumn(

        ) {
            items(notes) { note ->
                NoteLazyColumnItem(
                    note = note,
                    onNoteClicked = {
                        onRemoveNote(note)
                        Toast.makeText(context, "Note Removed", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Icon"
            )
        }, colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.LightGray
        )
    )
}

@Composable
fun NoteLazyColumnItem(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit,
) {

    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 32.dp,
                    bottomStart = 32.dp
                )
            )
            .fillMaxWidth(),
        color = Color.LightGray,
        shadowElevation = 6.dp,
    ) {
        Column(
            modifier = modifier
                .clickable {
                    onNoteClicked(note)
                }
                .padding(
                    horizontal = 12.dp,
                    vertical = 8.dp
                ),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = note.description,
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = formatDateFromLongToString(note.entryDate.time),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        notes = NotesDataSource().loadNotes(),
        onAddNote = {},
        onRemoveNote = {}
    )
}