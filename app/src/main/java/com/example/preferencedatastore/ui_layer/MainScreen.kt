package com.example.preferencedatastore.ui_layer

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(viewModel: MainViewModel){
    
    val userName = viewModel.userName.collectAsState()
    val text = remember{mutableStateOf("")}
    
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        
        Text(text = "Your saved name", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = userName.value, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(12.dp))
        
        Text(text = "Enter Your Name", style = MaterialTheme.typography.headlineMedium)
        
        OutlinedTextField(value = text.value, onValueChange = { text.value = it} )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Button(onClick = { viewModel.saveData(text.value)}) {
            Text(text = "Save Name")
            
        }
    }
}