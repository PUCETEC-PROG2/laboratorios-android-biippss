package ec.edu.puce.githubclient.ui.components

import android.R
import android.accessibilityservice.GestureDescription
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import java.net.URL


@Composable
fun RepoItem (
    name: String,
    description: String?,
    avatarURL: String,
    language: String?
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            AsyncImage(
                model = avatarURL,
                contentDescription = "imagen de $name",
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                if (!description.isNullOrBlank()) {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (!language.isNullOrBlank()) {
                    Text(
                        text = language,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun RepoItemPreview(){
    RepoItem(
        name = "repositorio de Israel",
        description = "repositorio creado por Israel",
        avatarURL = "aadsdsadsadsa",
        language = "JAVAAAA"
    )
}