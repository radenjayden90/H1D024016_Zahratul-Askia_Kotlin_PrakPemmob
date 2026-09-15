package com.example.cheesecake.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cheesecake.R

@Composable
fun BasicInfoScreen(
    onNavigateToContact: () -> Unit
) {
    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(
                    id = R.mipmap.ic_launcher_foreground
                ),
                contentDescription = "Logo Aplikasi",
                modifier = Modifier.size(120.dp)
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(
                text = "Jualan",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Aplikasi Jualan adalah platform yang mewadahi produk lokal UMKM di Wilayah Kabupaten Purbalingga, Jawa Tengah.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.onTertiary
                )
            ) {

                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Misi Kami",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "Memajukan UMKM Lokal",
                        color = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.weight(2f)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Button(
                onClick = onNavigateToContact,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Hubungi Kami",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}