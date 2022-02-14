package com.example.notezia

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notezia.ui.theme.NoteziaTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var testList = mutableListOf<NoteData>(
            NoteData("title", "text text"),
            NoteData("123123", "345345"),
            NoteData("wfwget", "wergwergwe"),
            NoteData("test", "text text   text     text text     text"),
            NoteData(
                "wwwwwwww wwwwwwwwwwwwwwwwwwwwwwww wwww wwwwwwwwww",
                "wwwwwwwwwwwww wwwwwwwwwwwwwwwww wwwww wwwwwwwwwwwww wwwwwwwwwwww wwwwwwwwwwwww wwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww wwww wwwwwwwwwwwww"
            )
        )
        for (i in 1..100) {
            testList.add(NoteData("title", "text text"))
            testList.add(NoteData("123123", "345345"))
        }

        super.onCreate(savedInstanceState)
        setContent {
            NoteziaTheme {
                NotesList(testList)
            }
        }
    }
}

data class NoteData(val title: String, val text: String)

@Composable
fun NotesList(notesList: List<NoteData>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(notesList) { noteData ->
                NoteCard(note = noteData)
            }
        }
    }
}

@Composable
fun NoteCard(note: NoteData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = MaterialTheme.colors.primary,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 9.dp, vertical = 4.dp)
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = note.text,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 3.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    NoteziaTheme {
//
//    }
//}
