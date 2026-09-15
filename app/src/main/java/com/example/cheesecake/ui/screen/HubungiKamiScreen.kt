package com.example.cheesecake.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cheesecake.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HubungiKamiScreen(
    navController: NavController?
) {

    // Menyimpan isi email
    var emailText by remember {
        mutableStateOf("")
    }

    // Menyimpan isi pesan
    var messageText by remember {
        mutableStateOf("")
    }

    // Digunakan untuk menjalankan Snackbar
    val scope = rememberCoroutineScope()

    // Mengontrol Snackbar
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Hubungi Kami"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController?.popBackStack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.back_icon
                            ),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },

        // Tempat Snackbar ditampilkan
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.padding(16.dp)
            ) { data ->
                Snackbar(
                    snackbarData = data,
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Judul halaman
            Text(
                text = "Hubungi Kami",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Input Email
            OutlinedTextField(
                value = emailText,
                onValueChange = {
                    emailText = it
                },
                label = {
                    Text("Email Anda")
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.mail_icon
                        ),
                        contentDescription = "Email"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Input Pesan
            OutlinedTextField(
                value = messageText,
                onValueChange = {
                    messageText = it
                },
                label = {
                    Text("Pesan")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            // Tombol Kirim Pesan
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Pesan Terkirim"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Icon(
                        painter = painterResource(
                            id = R.drawable.send_icon
                        ),
                        contentDescription = "Send"
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = "Kirim Pesan",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}