package com.compose.jetpackcomposelearn.databaseExample.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.compose.jetpackcomposelearn.databaseExample.domain.model.Person

@Composable
@Suppress("FunctionName")
fun PersonDialogDetail(person: Person, onDismiss: () -> Unit) {

    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(person.name, style = MaterialTheme.typography.titleLarge)
                Text("Age: ${person.age}")
                Text("Gender: ${if (person.gender) "Female" else "Male"}")
            }
        }
    }
}