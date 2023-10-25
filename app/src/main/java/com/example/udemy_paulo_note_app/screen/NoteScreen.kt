package com.example.udemy_paulo_note_app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.udemy_paulo_note_app.R
import com.example.udemy_paulo_note_app.components.NoteButton
import com.example.udemy_paulo_note_app.components.NoteInputText
import com.example.udemy_paulo_note_app.model.Note


@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var titleStateValue by remember { mutableStateOf("") }
    var descriptionStateValue by remember { mutableStateOf("") }

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

                        titleStateValue = ""
                        descriptionStateValue = ""
                    }
                }
            )
        }


    }
}

@Composable
private fun TopBar() {
    SmallTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "Icon"
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.LightGray
        )
    )
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(
        notes = emptyList(),
        onAddNote = {},
        onRemoveNote = {}
    )
}